package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.web.admin.vo.user.UserInfoQueryVo;

/**
* @author xieyv
* <p>表 user_info(用户信息表) 的数据库操作Mapper</p>
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfo> listByUserInfoQueryVo(Page<UserInfo> page, UserInfoQueryVo queryVo);
}




