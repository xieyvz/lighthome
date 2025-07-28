package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.CommunityFacility;
import com.xieyv.lighthome.web.app.mapper.CommunityFacilityMapper;
import com.xieyv.lighthome.web.app.service.CommunityFacilityService;
import org.springframework.stereotype.Service;

/**
*   community_facility(社区&配套关联表)
*/
@Service
public class CommunityFacilityServiceImpl extends ServiceImpl<CommunityFacilityMapper, CommunityFacility>
    implements CommunityFacilityService {
}




