package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.PaymentType;

import java.util.List;

/**
*   payment_type(支付方式表)
*/
public interface PaymentTypeService extends IService<PaymentType> {
    List<PaymentType> listByRoomId(Long id);
}
