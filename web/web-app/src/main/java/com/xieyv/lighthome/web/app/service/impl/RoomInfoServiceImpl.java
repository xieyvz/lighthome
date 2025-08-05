package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.mapper.*;
import com.xieyv.lighthome.web.app.service.CommunityInfoService;
import com.xieyv.lighthome.web.app.service.PaymentTypeService;
import com.xieyv.lighthome.web.app.service.RoomInfoService;
import com.xieyv.lighthome.web.app.vo.attr.AttrValueVo;
import com.xieyv.lighthome.web.app.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.app.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.app.vo.fee.FeeValueVo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import com.xieyv.lighthome.web.app.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.app.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.app.vo.room.RoomQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private CommunityInfoService communityInfoService;

    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private FeeValueMapper feeValueMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;


    @Override
    public IPage<RoomItemVo> listByQueryVo(Page<RoomItemVo> page, RoomQueryVo queryVo) {
        IPage<RoomItemVo> vo = roomInfoMapper.selectByQueryVo(page, queryVo);
        vo.getRecords().forEach(item -> {
            List<GraphVo> graphVos = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, item.getId());
            List<LabelInfo> labelInfos = labelInfoMapper.selectListByRoomId(item.getId());
            item.setGraphVoList(graphVos);
            item.setLabelInfoList(labelInfos);
        });
        return vo;
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {
        RoomInfo roomInfo = roomInfoMapper.selectById(id);
        RoomDetailVo detailVo = new RoomDetailVo();
        BeanUtils.copyProperties(roomInfo, detailVo);

        CommunityItemVo communityItemVo = new CommunityItemVo();
        CommunityDetailVo communityInfoDetailById = communityInfoService.getDetailById(detailVo.getCommunityId());
        BeanUtils.copyProperties(communityInfoDetailById, communityItemVo);

        List<GraphVo> graphVos = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, detailVo.getId());

        List<AttrValueVo> attrValueVos = attrValueMapper.selectVoListByRoomId(detailVo.getId());

        List<FacilityInfo> facilityInfos = facilityInfoMapper.selectListByRoomId(detailVo.getId());

        List<LabelInfo> labelInfos = labelInfoMapper.selectListByRoomId(detailVo.getId());

        List<PaymentType> paymentTypes = paymentTypeMapper.selectListByRoomId(detailVo.getId());

        List<FeeValueVo> feeValueVos = feeValueMapper.selectListVoByRoomId(id);

        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(detailVo.getId());

        detailVo.setCommunityItemVo(communityItemVo);
        detailVo.setGraphVoList(graphVos);
        detailVo.setAttrValueVoList(attrValueVos);
        detailVo.setFacilityInfoList(facilityInfos);
        detailVo.setLabelInfoList(labelInfos);
        detailVo.setPaymentTypeList(paymentTypes);
        detailVo.setFeeValueVoList(feeValueVos);
        detailVo.setLeaseTermList(leaseTermList);
        return detailVo;
    }

    @Override
    public IPage<RoomItemVo> listByRoomId(Page<RoomItemVo> page, Long id) {
        IPage<RoomItemVo> vo = roomInfoMapper.selectByRoomId(page, id);
        vo.getRecords().forEach(item -> {
            String commuityId = item.getRoomNumber();
            String[] split = commuityId.split(",");
            item.setRoomNumber(split[0]);
            commuityId = split[1];
            item.setCommunityInfo(communityInfoService.getById(commuityId));
            item.setGraphVoList(graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, item.getId()));
            item.setLabelInfoList(labelInfoMapper.selectListByRoomId(item.getId()));
        });
        return vo;
    }
}




