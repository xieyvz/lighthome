package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.FeeKey;
import com.xieyv.lighthome.model.entity.FeeValue;
import com.xieyv.lighthome.web.admin.service.FeeKeyService;
import com.xieyv.lighthome.web.admin.service.FeeValueService;
import com.xieyv.lighthome.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间杂费管理")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Autowired
    FeeKeyService feeKeyService;
    @Autowired
    FeeValueService feeValueService;

    @Operation(summary = "保存或更新杂费名称")
    @PostMapping("key/saveOrUpdate")
    public Result<Void> saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }

    @Operation(summary = "保存或更新杂费值")
    @PostMapping("value/saveOrUpdate")
    public Result<Void> saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }


    @Operation(summary = "查询全部杂费名称和杂费值列表")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        List<FeeKeyVo> list = feeKeyService.listFeeInfo();
        return Result.ok(list);
    }

    @Operation(summary = "根据id删除杂费名称")
    @DeleteMapping("key/deleteById")
    public Result<Void> deleteFeeKeyById(@RequestParam Long feeKeyId) {
        feeKeyService.removeById(feeKeyId);
        LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FeeValue::getFeeKeyId, feeKeyId);
        feeValueService.remove(queryWrapper);
        return Result.ok();
    }

    @Operation(summary = "根据id删除杂费值")
    @DeleteMapping("value/deleteById")
    public Result<Void> deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
        return Result.ok();
    }
}
