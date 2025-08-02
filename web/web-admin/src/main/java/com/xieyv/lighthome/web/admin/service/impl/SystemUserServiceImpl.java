package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.web.admin.mapper.SystemUserMapper;
import com.xieyv.lighthome.web.admin.service.SystemUserService;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserItemVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * system_user(员工信息表)
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public IPage<SystemUserItemVo> listByQueryVo(Page<SystemUserItemVo> page,
                                                 SystemUserQueryVo queryVo) {
        return systemUserMapper.listByQueryVo(page, queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserItemVoById(Long id) {
        return systemUserMapper.selectSystemUserItemVoById(id);
    }

}




