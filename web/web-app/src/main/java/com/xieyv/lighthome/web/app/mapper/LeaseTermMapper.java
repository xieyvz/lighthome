package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.LeaseTerm;

import java.util.List;

/**
* lease_term(租期)
*/
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {


    List<LeaseTerm> selectListByRoomId(Long id);
}




