package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.SystemPost;
import com.xieyv.lighthome.web.admin.mapper.SystemPostMapper;
import com.xieyv.lighthome.web.admin.service.SystemPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* system_post(岗位信息表)
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService {

    @Autowired
    SystemPostMapper systemPostMapper;

    @Override
    public IPage<SystemPost> listPage(Page<SystemPost> page) {
        return systemPostMapper.listPage(page);
    }
}




