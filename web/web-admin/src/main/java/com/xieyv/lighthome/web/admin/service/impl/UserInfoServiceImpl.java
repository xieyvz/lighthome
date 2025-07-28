package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.web.admin.mapper.UserInfoMapper;
import com.xieyv.lighthome.web.admin.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* user_info(用户信息表)
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}




