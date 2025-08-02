package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserItemVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserQueryVo;

/**
 * @author xieyv
 *<p>表system_user(员工信息表)的service<p/>
 */
public interface SystemUserService extends IService<SystemUser> {

    IPage<SystemUserItemVo> listByQueryVo(Page<SystemUserItemVo> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getSystemUserItemVoById(Long id);

}
