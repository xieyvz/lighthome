package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.web.admin.mapper.ViewAppointmentMapper;
import com.xieyv.lighthome.web.admin.service.ViewAppointmentService;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentQueryVo;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * view_appointment(预约看房信息表)
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;

    @Override
    public IPage<AppointmentVo> getAppointmentVo(Page<AppointmentVo> page, AppointmentQueryVo queryVo) {
        return viewAppointmentMapper.selectByQueryVo(page, queryVo);
    }
}




