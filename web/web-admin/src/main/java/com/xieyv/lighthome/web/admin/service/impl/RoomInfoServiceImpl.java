package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.admin.mapper.*;
import com.xieyv.lighthome.web.admin.service.*;
import com.xieyv.lighthome.web.admin.vo.attr.AttrValueVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomQueryVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomSubmitVo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * room_info(房间信息表)
 */
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {
    @Autowired
    private GraphInfoService graphInfoService;
    @Autowired
    private RoomAttrValueService attrValueService;
    @Autowired
    private RoomFacilityService facilityService;
    @Autowired
    private RoomLabelService labelService;
    @Autowired
    private RoomPaymentTypeService paymentTypeService;
    @Autowired
    private RoomLeaseTermService leaseTermService;

    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    CommunityInfoMapper communityInfoMapper;
    @Autowired
    GraphInfoMapper graphInfoMapper;
    @Autowired
    AttrValueMapper attrValueMapper;
    @Autowired
    FacilityInfoMapper facilityInfoMapper;
    @Autowired
    LabelInfoMapper labelInfoMapper;
    @Autowired
    PaymentTypeMapper paymentTypeMapper;
    @Autowired
    LeaseTermMapper leaseTermMapper;

    @Override
    public void saveOrUpdateInfo(RoomSubmitVo submitVo) {
        super.saveOrUpdate(submitVo);
        boolean isUpdate = submitVo.getId() != null;
        if(isUpdate){
            //移除图片列表
            LambdaQueryWrapper<GraphInfo> graphInfoQueryWrapper = new LambdaQueryWrapper<>();
            graphInfoQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM)
                    .eq(GraphInfo::getItemId, submitVo.getId());
            graphInfoService.remove(graphInfoQueryWrapper);
            //属性信息列表
            LambdaQueryWrapper<RoomAttrValue> attrValueQueryWrapper = new LambdaQueryWrapper<>();
            attrValueQueryWrapper.eq(RoomAttrValue::getRoomId, submitVo.getId());
            attrValueService.remove(attrValueQueryWrapper);
            //配套信息列表
            LambdaQueryWrapper<RoomFacility> facilityQueryWrapper = new LambdaQueryWrapper<>();
            facilityQueryWrapper.eq(RoomFacility::getRoomId, submitVo.getId());
            facilityService.remove(facilityQueryWrapper);
            //标签信息列表
            LambdaQueryWrapper<RoomLabel> labelQueryWrapper = new LambdaQueryWrapper<>();
            labelQueryWrapper.eq(RoomLabel::getRoomId, submitVo.getId());
            labelService.remove(labelQueryWrapper);
            //支付方式列表
            LambdaQueryWrapper<RoomPaymentType> paymentTypeQueryWrapper = new LambdaQueryWrapper<>();
            paymentTypeQueryWrapper.eq(RoomPaymentType::getRoomId, submitVo.getId());
            paymentTypeService.remove(paymentTypeQueryWrapper);
            //可选租期列表
            LambdaQueryWrapper<RoomLeaseTerm> leaseTermQueryWrapper = new LambdaQueryWrapper<>();
            leaseTermQueryWrapper.eq(RoomLeaseTerm::getRoomId, submitVo.getId());
            leaseTermService.remove(leaseTermQueryWrapper);
        }
        //save
        //图片列表
        List<GraphVo> graphVoList = submitVo.getGraphVoList();
        if(!CollectionUtils.isEmpty(graphVoList)){
            ArrayList<GraphInfo> graphVoArrayList = new ArrayList<>();
            graphVoList.forEach(graphVo -> {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemType(ItemType.ROOM);
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfo.setItemId(submitVo.getId());
                graphVoArrayList.add(graphInfo);
            });
            graphInfoService.saveBatch(graphVoArrayList);
        }
        //属性信息列表
        List<Long> attrValueIds = submitVo.getAttrValueIds();
        if(!CollectionUtils.isEmpty(attrValueIds)){
            ArrayList<RoomAttrValue> roomAttrValues = new ArrayList<>();
            attrValueIds.forEach(id -> {
                RoomAttrValue attrValue = RoomAttrValue.builder()
                        .roomId(submitVo.getId()).attrValueId(id).build();
                roomAttrValues.add(attrValue);
            });
            attrValueService.saveBatch(roomAttrValues);
        }
        //配套信息列表
        List<Long> facilityInfoIds = submitVo.getFacilityInfoIds();
        if(!CollectionUtils.isEmpty(facilityInfoIds)){
            ArrayList<RoomFacility> roomFacilities = new ArrayList<>();
            facilityInfoIds.forEach(id -> {
                RoomFacility facility = RoomFacility.builder().roomId(submitVo.getId()).facilityId(id).build();
                roomFacilities.add(facility);
            });
            facilityService.saveBatch(roomFacilities);
        }
        //标签信息列表
        List<Long> labelInfoIds = submitVo.getLabelInfoIds();
        if(!CollectionUtils.isEmpty(labelInfoIds)){
            ArrayList<RoomLabel> roomLabels = new ArrayList<>();
            labelInfoIds.forEach(id -> {
                roomLabels.add(RoomLabel.builder().roomId(submitVo.getId()).labelId(id).build());
            });
            labelService.saveBatch(roomLabels);
        }
        //支付方式列表
        List<Long> paymentTypeIds = submitVo.getPaymentTypeIds();
        if(!CollectionUtils.isEmpty(paymentTypeIds)){
            ArrayList<RoomPaymentType> roomPaymentTypes = new ArrayList<>();
            paymentTypeIds.forEach(id -> {
                roomPaymentTypes.add(RoomPaymentType.builder().roomId(submitVo.getId())
                        .paymentTypeId(id).build());
            });
            paymentTypeService.saveBatch(roomPaymentTypes);
        }
        //可选租期列表
        List<Long> leaseTermIds = submitVo.getLeaseTermIds();
        if(!CollectionUtils.isEmpty(leaseTermIds)){
            ArrayList<RoomLeaseTerm> roomLeaseTerms = new ArrayList<>();
            leaseTermIds.forEach(id -> {
                roomLeaseTerms.add(RoomLeaseTerm.builder().roomId(submitVo.getId())
                        .leaseTermId(id).build());
            });
            leaseTermService.saveBatch(roomLeaseTerms);
        }
    }

    @Override
    public IPage<RoomItemVo> listByQueryVo(Page<CommunityItemVo> voPage, RoomQueryVo queryVo) {
        return roomInfoMapper.listByQueryVo(voPage, queryVo);
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {
        RoomInfo roomInfo = super.getById(id);
        //所属社区信息
        CommunityInfo communityInfo = communityInfoMapper.selectById(roomInfo.getCommunityId());
        //图片列表
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);
        //属性信息列表
        List<AttrValueVo> attrValueVoList = attrValueMapper.selectByIdRoomId(id);
        //配套信息列表
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
        //标签信息列表
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);
        //支付方式列表
        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);
        //可选租期列表
        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoodId(id);
        RoomDetailVo result = new RoomDetailVo();
        BeanUtils.copyProperties(roomInfo, result);
        result.setGraphVoList(graphVoList);
        result.setAttrValueVoList(attrValueVoList);
        result.setFacilityInfoList(facilityInfoList);
        result.setLabelInfoList(labelInfoList);
        result.setPaymentTypeList(paymentTypeList);
        result.setLeaseTermList(leaseTermList);
        return result;
    }

    @Override
    public void removeInfoById(Long id) {
        super.removeById(id);
        //移除图片列表
        LambdaQueryWrapper<GraphInfo> graphInfoQueryWrapper = new LambdaQueryWrapper<>();
        graphInfoQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM)
                .eq(GraphInfo::getItemId, id);
        graphInfoService.remove(graphInfoQueryWrapper);
        //属性信息列表
        LambdaQueryWrapper<RoomAttrValue> attrValueQueryWrapper = new LambdaQueryWrapper<>();
        attrValueQueryWrapper.eq(RoomAttrValue::getRoomId, id);
        attrValueService.remove(attrValueQueryWrapper);
        //配套信息列表
        LambdaQueryWrapper<RoomFacility> facilityQueryWrapper = new LambdaQueryWrapper<>();
        facilityQueryWrapper.eq(RoomFacility::getRoomId, id);
        facilityService.remove(facilityQueryWrapper);
        //标签信息列表
        LambdaQueryWrapper<RoomLabel> labelQueryWrapper = new LambdaQueryWrapper<>();
        labelQueryWrapper.eq(RoomLabel::getRoomId, id);
        labelService.remove(labelQueryWrapper);
        //支付方式列表
        LambdaQueryWrapper<RoomPaymentType> paymentTypeQueryWrapper = new LambdaQueryWrapper<>();
        paymentTypeQueryWrapper.eq(RoomPaymentType::getRoomId, id);
        paymentTypeService.remove(paymentTypeQueryWrapper);
        //可选租期列表
        LambdaQueryWrapper<RoomLeaseTerm> leaseTermQueryWrapper = new LambdaQueryWrapper<>();
        leaseTermQueryWrapper.eq(RoomLeaseTerm::getRoomId, id);
        leaseTermService.remove(leaseTermQueryWrapper);
    }
}




