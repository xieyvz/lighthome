package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityQueryVo;

/**
* @author xieyv
* <p>表 community_info(社区信息表)的数据库操作 Mapper<p/>
*/
public interface CommunityInfoMapper extends BaseMapper<CommunityInfo> {

    IPage<CommunityItemVo> listByQueryVo(Page<CommunityItemVo> voPage, CommunityQueryVo queryVo);
}




