package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.web.app.vo.appointment.AppointmentDetailVo;
import com.xieyv.lighthome.web.app.vo.appointment.AppointmentItemVo;

import java.util.List;

/**
*   view_appointment(预约看房信息表)
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {
    List<AppointmentItemVo> listItem();

    AppointmentDetailVo getDetailById(Long id);
}
