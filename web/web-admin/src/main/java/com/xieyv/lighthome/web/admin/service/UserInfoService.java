package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.web.admin.vo.user.UserInfoQueryVo;

/**
 * @author xieyv
 *<p>表 user_info(用户信息表)的service<p/>
 */
public interface UserInfoService extends IService<UserInfo> {

    IPage<UserInfo> listByUserInfoQueryVo(Page<UserInfo> page, UserInfoQueryVo queryVo);
}
