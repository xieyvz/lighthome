package com.xieyv.lighthome.web.admin.controller.user;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.model.enums.BaseStatus;
import com.xieyv.lighthome.web.admin.service.UserInfoService;
import com.xieyv.lighthome.web.admin.vo.user.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "分页查询用户信息")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current,
                                                @RequestParam long size, UserInfoQueryVo queryVo) {
        Page<UserInfo> page = new Page<>(current, size);
        IPage<UserInfo> result = userInfoService.listByUserInfoQueryVo(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "根据用户id更新账号状态")
    @PostMapping("updateStatusById")
    public Result<Void> updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        userInfoService.update(new LambdaUpdateWrapper<UserInfo>()
                .eq(UserInfo::getId, id).set(UserInfo::getStatus, status));
        return Result.ok();
    }
}
