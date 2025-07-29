package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.admin.mapper.CommunityInfoMapper;
import com.xieyv.lighthome.web.admin.service.*;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    /**
     * @param submitVo
     *  保存或更新社区信息，  <br>
     *  逻辑为如果是新增，则直接添加  <br>
     *  如果是修改，则先删除所有数据，再添加修改后的列表
     */
    @Override
    public void saveOrUpdateInfo(CommunitySubmitVo submitVo) {
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
    }
}




