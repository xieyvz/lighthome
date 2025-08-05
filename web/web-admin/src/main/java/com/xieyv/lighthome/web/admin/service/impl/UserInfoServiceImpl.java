package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.web.admin.mapper.UserInfoMapper;
import com.xieyv.lighthome.web.admin.service.UserInfoService;
import com.xieyv.lighthome.web.admin.vo.user.UserInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* user_info(用户信息表)
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public IPage<UserInfo> listByUserInfoQueryVo(Page<UserInfo> page, UserInfoQueryVo queryVo) {
        return userInfoMapper.listByUserInfoQueryVo(page, queryVo);
    }
}




