package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityQueryVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;

/**
 * @author xieyv
 * <p>表 community_info(社区信息表)的service<p/>
 */
public interface CommunityInfoService extends IService<CommunityInfo> {

    void saveOrUpdateInfo(CommunitySubmitVo communitySubmitVo);

    IPage<CommunityItemVo> listByQueryVo(Page<CommunityItemVo> voPage, CommunityQueryVo queryVo);

    CommunityDetailVo getDetailById(Long id);

    void removeInfoById(Long id);
}
