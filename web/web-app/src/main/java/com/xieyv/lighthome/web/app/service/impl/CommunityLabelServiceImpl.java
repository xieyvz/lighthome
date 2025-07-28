package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.CommunityLabel;
import com.xieyv.lighthome.web.app.mapper.CommunityLabelMapper;
import com.xieyv.lighthome.web.app.service.CommunityLabelService;
import org.springframework.stereotype.Service;

/**
*
*   apartment_label(社区标签关联表)
*/
@Service
public class CommunityLabelServiceImpl extends ServiceImpl<CommunityLabelMapper, CommunityLabel>
    implements CommunityLabelService {
}
