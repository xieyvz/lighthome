package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.app.vo.community.CommunityDetailVo;

/**
 * apartment_info(公寓信息表)
 */
public interface CommunityInfoService extends IService<CommunityInfo> {
    CommunityDetailVo getDetailById(Long id);
}
