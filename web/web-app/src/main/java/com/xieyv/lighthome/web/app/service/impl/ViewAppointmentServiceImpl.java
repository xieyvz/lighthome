package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.mapper.GraphInfoMapper;
import com.xieyv.lighthome.web.app.mapper.ViewAppointmentMapper;
import com.xieyv.lighthome.web.app.service.CommunityInfoService;
import com.xieyv.lighthome.web.app.service.ViewAppointmentService;
import com.xieyv.lighthome.web.app.vo.appointment.AppointmentDetailVo;
import com.xieyv.lighthome.web.app.vo.appointment.AppointmentItemVo;
import com.xieyv.lighthome.web.app.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.app.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  view_appointment(预约看房信息表)
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private CommunityInfoService communityInfoService;

    @Override
    public List<AppointmentItemVo> listItem() {
        List<ViewAppointment> appointmentItems = viewAppointmentMapper.selectListItem();
        ArrayList<AppointmentItemVo> vos = new ArrayList<>();
        appointmentItems.forEach(item -> {
            List<GraphVo> graphVos = graphInfoMapper.selectListByItemTypeAndId(ItemType.COMMUNITY, item.getCommunityId());
            AppointmentItemVo vo = new AppointmentItemVo();
            vo.setId(item.getId());
            vo.setCommunityName(item.getName());
            vo.setGraphVoList(graphVos);
            vo.setAppointmentTime(item.getAppointmentTime());
            vo.setAppointmentStatus(item.getAppointmentStatus());
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public AppointmentDetailVo getDetailById(Long id) {
        ViewAppointment viewAppointment = viewAppointmentMapper.selectById(id);
        AppointmentDetailVo vo = new AppointmentDetailVo();
        BeanUtils.copyProperties(viewAppointment, vo);
        CommunityDetailVo detailVo = communityInfoService.getDetailById(vo.getCommunityId());
        CommunityItemVo itemVo = new CommunityItemVo();
        BeanUtils.copyProperties(detailVo, itemVo);
        vo.setCommunityItemVo(itemVo);
        return vo;
    }
}




