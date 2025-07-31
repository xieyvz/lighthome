package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.common.exception.LhException;
import com.xieyv.lighthome.common.result.ResultCodeEnum;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.admin.mapper.*;
import com.xieyv.lighthome.web.admin.service.*;
import com.xieyv.lighthome.web.admin.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityQueryVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;
import com.xieyv.lighthome.web.admin.vo.fee.FeeValueVo;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * apartment_info(公寓信息表)
 */
@Service
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo>
        implements CommunityInfoService {

    @Autowired
    private CommunityFacilityService facilityService;
    @Autowired
    private CommunityLabelService labelService;
    @Autowired
    private CommunityFeeValueService feeValueService;
    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    LabelInfoMapper labelInfoMapper;
    @Autowired
    FacilityInfoMapper facilityInfoMapper;
    @Autowired
    FeeValueMapper feeValueMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;

    /**
     * @param submitVo
     *  保存或更新社区信息，  <br>
     *  逻辑为如果是新增，则直接添加  <br>
     *  如果是修改，则先删除所有数据，再添加修改后的列表
     */
    @Override
    public void saveOrUpdateInfo(CommunitySubmitVo submitVo) {
        super.saveOrUpdate(submitVo);
        //传入主键则为修改，反之新增，后执行super防止回显干扰
        boolean isUpdate = submitVo.getId() != null;
        if (isUpdate) {
            //修改> 先删除 后插入
            LambdaQueryWrapper<CommunityFacility> facilityQueryWrapper
                    = new LambdaQueryWrapper<>();
            facilityQueryWrapper.eq(CommunityFacility::getCommunityId, submitVo.getId());
            facilityService.remove(facilityQueryWrapper);

            LambdaQueryWrapper<CommunityLabel> labelQueryWrapper
                    = new LambdaQueryWrapper<>();
            labelQueryWrapper.eq(CommunityLabel::getCommunityId, submitVo.getId());
            labelService.remove(labelQueryWrapper);

            LambdaQueryWrapper<CommunityFeeValue> feeValueQueryWrapper
                    = new LambdaQueryWrapper<>();
            feeValueQueryWrapper.eq(CommunityFeeValue::getCommunityId, submitVo.getId());
            feeValueService.remove(feeValueQueryWrapper);

            LambdaQueryWrapper<GraphInfo> graphInfoQueryWrapper
                    = new LambdaQueryWrapper<>();
            graphInfoQueryWrapper.eq(GraphInfo::getItemType, ItemType.COMMUNITY)
                    .eq(GraphInfo::getId, submitVo.getId());
            graphInfoService.remove(graphInfoQueryWrapper);
        }
        //插入数据
        List<Long> facilityInfoList = submitVo.getFacilityInfoIds();
        if(!CollectionUtils.isEmpty(facilityInfoList)){
            ArrayList<CommunityFacility> facilityList = new ArrayList<>();
            facilityInfoList.forEach(id -> {
                CommunityFacility facility = CommunityFacility.builder().build();
                facility.setCommunityId(submitVo.getId());
                facility.setFacilityId(id);
                facilityList.add(facility);
            });
            facilityService.saveBatch(facilityList);
        }

        List<Long> labelIds = submitVo.getLabelIds();
        if(!CollectionUtils.isEmpty(labelIds)){
            ArrayList<CommunityLabel> labelList = new ArrayList<>();
            labelIds.forEach(id -> {
                CommunityLabel label = CommunityLabel.builder().build();
                label.setCommunityId(submitVo.getId());
                label.setLabelId(id);
                labelList.add(label);
            });
            labelService.saveBatch(labelList);
        }

        List<Long> feeValueIds = submitVo.getFeeValueIds();
        if(!CollectionUtils.isEmpty(feeValueIds)){
            ArrayList<CommunityFeeValue> feeValueList = new ArrayList<>();
            feeValueIds.forEach(id -> {
                CommunityFeeValue feeValue = CommunityFeeValue.builder().build();
                feeValue.setCommunityId(submitVo.getId());
                feeValue.setFeeValueId(id);
                feeValueList.add(feeValue);
            });
            feeValueService.saveBatch(feeValueList);
        }

        List<GraphVo> graphVoList = submitVo.getGraphVoList();
        if(!CollectionUtils.isEmpty(graphVoList)){
            ArrayList<GraphInfo> graphInfoList = new ArrayList<>();
            graphVoList.forEach(graphVo -> {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemType(ItemType.COMMUNITY);
                graphInfo.setItemId(submitVo.getId());
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfoList.add(graphInfo);
            });
            graphInfoService.saveBatch(graphInfoList);
        }
        //super.save(submitVo);
    }

    @Override
    public IPage<CommunityItemVo> listByQueryVo(Page<CommunityItemVo> voPage, CommunityQueryVo queryVo) {
        return communityInfoMapper.listByQueryVo(voPage, queryVo);
    }

    @Override
    public CommunityDetailVo getDetailById(Long id) {
        //社区信息extends
        CommunityInfo info = communityInfoMapper.selectById(id);
        //图片列表，图片类型(社区)，所属社区id
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.COMMUNITY, id);
        //标签
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByCommunityId(id);
        //配套
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByCommunityId(id);
        //杂费
        List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByCommunityId(id);
        //组装
        CommunityDetailVo result = new CommunityDetailVo();
        BeanUtils.copyProperties(info, result);
        result.setGraphVoList(graphVoList);
        result.setLabelInfoList(labelInfoList);
        result.setFacilityInfoList(facilityInfoList);
        result.setFeeValueVoList(feeValueVoList);
        return result;
    }

    @Override
    public void removeInfoById(Long id) {
        LambdaQueryWrapper<RoomInfo> roomInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomInfoLambdaQueryWrapper.eq(RoomInfo::getCommunityId, id);
        Long roomCount = roomInfoMapper.selectCount(roomInfoLambdaQueryWrapper);
        if(roomCount > 0){
            //提示用户该社区内还有房间
            throw new LhException(ResultCodeEnum.DELETE_ERROR);
        }
        super.removeById(id);
        LambdaQueryWrapper<CommunityFacility> facilityQueryWrapper
                = new LambdaQueryWrapper<>();
        facilityQueryWrapper.eq(CommunityFacility::getCommunityId, id);
        facilityService.remove(facilityQueryWrapper);

        LambdaQueryWrapper<CommunityLabel> labelQueryWrapper
                = new LambdaQueryWrapper<>();
        labelQueryWrapper.eq(CommunityLabel::getCommunityId, id);
        labelService.remove(labelQueryWrapper);

        LambdaQueryWrapper<CommunityFeeValue> feeValueQueryWrapper
                = new LambdaQueryWrapper<>();
        feeValueQueryWrapper.eq(CommunityFeeValue::getCommunityId, id);
        feeValueService.remove(feeValueQueryWrapper);

        LambdaQueryWrapper<GraphInfo> graphInfoQueryWrapper
                = new LambdaQueryWrapper<>();
        graphInfoQueryWrapper.eq(GraphInfo::getItemType, ItemType.COMMUNITY)
                .eq(GraphInfo::getId,  id);
        graphInfoService.remove(graphInfoQueryWrapper);
    }
}




