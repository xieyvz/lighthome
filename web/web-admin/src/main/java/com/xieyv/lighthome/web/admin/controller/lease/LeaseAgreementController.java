package com.xieyv.lighthome.web.admin.controller.lease;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.model.enums.LeaseStatus;
import com.xieyv.lighthome.web.admin.service.LeaseAgreementService;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementQueryVo;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "租约管理")
@RestController
@RequestMapping("/admin/agreement")
public class   LeaseAgreementController {
    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Operation(summary = "保存或修改租约信息")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        leaseAgreementService.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }

    @Operation(summary = "根据条件分页查询租约列表")
    @GetMapping("page")
    public Result<IPage<AgreementVo>> page(@RequestParam long current,
                                           @RequestParam long size, AgreementQueryVo queryVo) {
        Page<AgreementVo> page = new Page<>(current, size);
        IPage<AgreementVo> list = leaseAgreementService.getAgreementVoByAgreementQueryVo(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "根据id查询租约信息")
    @GetMapping(name = "getById")
    public Result<AgreementVo> getById(@RequestParam Long id) {
        return Result.ok(leaseAgreementService.getAgreementVoById(id));
    }

    @Operation(summary = "根据id删除租约信息")
    @DeleteMapping("removeById")
    public Result<Void> removeById(@RequestParam Long id) {
        leaseAgreementService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据id更新租约状态")
    @PostMapping("updateStatusById")
    public Result<Void> updateStatusById(@RequestParam Long id,
                                         @RequestParam LeaseStatus status) {
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LeaseAgreement::getId, id).set(LeaseAgreement::getStatus, status);
        leaseAgreementService.update(updateWrapper);
        return Result.ok();
    }

}

