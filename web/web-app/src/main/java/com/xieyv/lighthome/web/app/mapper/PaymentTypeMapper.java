package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.PaymentType;

import java.util.List;

/**
*   payment_type(支付方式表)
*/
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long id);
}




