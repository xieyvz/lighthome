package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.CommunityFeeValue;
import com.xieyv.lighthome.web.app.mapper.CommunityFeeValueMapper;
import com.xieyv.lighthome.web.app.service.CommunityFeeValueService;
import org.springframework.stereotype.Service;

/**
*   community_fee_value(社区&杂费关联表)
*/
@Service
public class CommunityFeeValueServiceImpl extends ServiceImpl<CommunityFeeValueMapper, CommunityFeeValue>
    implements CommunityFeeValueService {
}




