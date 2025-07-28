package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.web.admin.mapper.SystemUserMapper;
import com.xieyv.lighthome.web.admin.service.SystemUserService;
import org.springframework.stereotype.Service;

/**
 * system_user(员工信息表)
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

}




