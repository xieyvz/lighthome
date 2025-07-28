package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.app.mapper.CommunityInfoMapper;
import com.xieyv.lighthome.web.app.service.CommunityInfoService;
import org.springframework.stereotype.Service;

/**
 *  apartment_info(公寓信息表)
 */
@Service
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo>
        implements CommunityInfoService {
}




