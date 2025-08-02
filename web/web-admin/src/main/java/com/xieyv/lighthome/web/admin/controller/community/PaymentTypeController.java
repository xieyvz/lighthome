package com.xieyv.lighthome.web.admin.controller.community;

import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.PaymentType;
import com.xieyv.lighthome.web.admin.service.PaymentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "支付方式管理")
@RequestMapping("/admin/payment")
@RestController
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "查询全部支付方式列表")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {
        List<PaymentType> list = paymentTypeService.list();
        return Result.ok(list);
    }

    @Operation(summary = "保存或更新支付方式")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        paymentTypeService.saveOrUpdate(paymentType);
        return Result.ok();
    }

    @Operation(summary = "根据ID删除支付方式")
    @DeleteMapping("deleteById")
    public Result<Void> deletePaymentById(@RequestParam Long id) {
        paymentTypeService.removeById(id);  //配置过逻辑删除，实则为update
        return Result.ok();
    }

}