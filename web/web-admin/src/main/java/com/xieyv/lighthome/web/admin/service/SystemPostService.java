package com.xieyv.lighthome.web.admin.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.SystemPost;

/**
 * @author xieyv
 *<p>表 system_post(岗位信息表)的service<p/>
 */
public interface SystemPostService extends IService<SystemPost> {

    IPage<SystemPost> listPage(Page<SystemPost> page);
}
