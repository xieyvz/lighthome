package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.RoomPaymentType;
import com.xieyv.lighthome.web.app.mapper.RoomPaymentTypeMapper;
import com.xieyv.lighthome.web.app.service.RoomPaymentTypeService;
import org.springframework.stereotype.Service;

/**
*   room_payment_type(房间&支付方式关联表)
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService {

}




