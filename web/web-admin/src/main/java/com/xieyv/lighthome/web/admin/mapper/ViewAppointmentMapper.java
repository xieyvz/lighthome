package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentQueryVo;
import com.xieyv.lighthome.web.admin.vo.appointment.AppointmentVo;

/**
* @author xieyv
* <p>表 view_appointment(预约看房信息表) 的数据库操作Mapper</p>
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> selectByQueryVo(Page<AppointmentVo> page, AppointmentQueryVo queryVo);
}




