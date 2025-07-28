package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.PaymentType;
import com.xieyv.lighthome.web.admin.mapper.PaymentTypeMapper;
import com.xieyv.lighthome.web.admin.service.PaymentTypeService;
import org.springframework.stereotype.Service;

/**
* payment_type(支付方式表)
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService {

}




