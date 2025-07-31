package com.xieyv.lighthome.web.admin.controller.community;

import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.LeaseTerm;
import com.xieyv.lighthome.web.admin.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "租期管理")
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {

    @Autowired
    LeaseTermService leaseTermService;

    @GetMapping("list")
    @Operation(summary = "查询全部租期列表")
    public Result<List<LeaseTerm>> listLeaseTerm() {
        List<LeaseTerm> list = leaseTermService.list();
        return Result.ok(list);
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "保存或更新租期信息")
    public Result<Void> saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        leaseTermService.saveOrUpdate(leaseTerm);
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除租期")
    public Result<Void> deleteLeaseTermById(@RequestParam Long id) {
        leaseTermService.removeById(id);
        return Result.ok();
    }
}
