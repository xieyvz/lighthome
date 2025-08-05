package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.mapper.*;
import com.xieyv.lighthome.web.app.service.CommunityInfoService;
import com.xieyv.lighthome.web.app.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.app.vo.fee.FeeValueVo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 *  apartment_info(公寓信息表)
 */
@Service
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo>
        implements CommunityInfoService {
    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;


    @Override
    public CommunityDetailVo getDetailById(Long id) {
        CommunityInfo communityInfo = communityInfoMapper.selectById(id);

        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.COMMUNITY, id);
        //标签
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByCommunityId(id);
        //配套
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByCommunityId(id);
        //租金最小值
        BigDecimal minRent = roomInfoMapper.selectMinRentByCommunityId(id);

        CommunityDetailVo vo = new CommunityDetailVo();
        BeanUtils.copyProperties(communityInfo, vo);
        vo.setGraphVoList(graphVoList);
        vo.setLabelInfoList(labelInfoList);
        vo.setFacilityInfoList(facilityInfoList);
        vo.setMinRent(minRent);
        return vo;
    }
}




