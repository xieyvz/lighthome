package com.xieyv.lighthome.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.model.enums.BaseStatus;
import com.xieyv.lighthome.web.admin.service.SystemUserService;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserItemVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台用户信息管理")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current,
                                                @RequestParam long size,
                                                SystemUserQueryVo queryVo) {
        Page<SystemUserItemVo> page = new Page<>(current, size);
        IPage<SystemUserItemVo> list = systemUserService.listByQueryVo(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo vo = systemUserService.getSystemUserItemVoById(id);
        return Result.ok(vo);
    }

    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdate(@RequestBody SystemUser systemUser) {
        if(systemUser.getPassword() != null){
            //md5单向加密密码
            systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword()));
        }
        systemUserService.saveOrUpdate(systemUser);
        return Result.ok();
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        long count = systemUserService.count(
                new LambdaQueryWrapper<SystemUser>().eq(SystemUser::getUsername, username));
        return Result.ok(count == 0);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result<Void> removeById(@RequestParam Long id) {
        systemUserService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result<Void> updateStatusByUserId(@RequestParam Long id,
                                       @RequestParam BaseStatus status) {
        systemUserService.update(new LambdaUpdateWrapper<SystemUser>()
                .eq(SystemUser::getId, id)
                .set(SystemUser::getStatus, status));
        return Result.ok();
    }
}
