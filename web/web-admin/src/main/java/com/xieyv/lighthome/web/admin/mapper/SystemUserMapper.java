package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserItemVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserQueryVo;

/**
* @author xieyv
* <p>表system_user(员工信息表)的数据库操作 Mapper<p/>
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> listByQueryVo(Page<SystemUserItemVo> page, SystemUserQueryVo queryVo);

    SystemUserItemVo selectSystemUserItemVoById(Long id);

    SystemUser selectByUserName(String username);
}




