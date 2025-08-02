package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.SystemPost;

/**
* @author xieyv
* <p>表 system_post(岗位信息表)的数据库操作 Mapper<p/>
*/
public interface SystemPostMapper extends BaseMapper<SystemPost> {

    IPage<SystemPost> listPage(Page<SystemPost> page);
}




