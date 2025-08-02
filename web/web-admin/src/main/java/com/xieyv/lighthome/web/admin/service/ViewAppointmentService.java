package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentQueryVo;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentVo;

/**
 * @author xieyv
 *<p>表 view_appointment(预约看房信息表)的service<p/>
 */
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> getAppointmentVo(Page<AppointmentVo> page, AppointmentQueryVo queryVo);
}
