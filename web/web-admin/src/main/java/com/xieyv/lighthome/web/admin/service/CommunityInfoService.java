package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;

/**
 * @author xieyv
 * <p>表 community_info(社区信息表)的service<p/>
 */
public interface CommunityInfoService extends IService<CommunityInfo> {

    void saveOrUpdateInfo(CommunitySubmitVo communitySubmitVo);
}
