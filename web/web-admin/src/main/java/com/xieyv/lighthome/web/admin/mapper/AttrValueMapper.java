package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.AttrValue;
import com.xieyv.lighthome.web.admin.vo.attr.AttrValueVo;

import java.util.List;

/**
* @author xieyv
* <p>表 attr_value(房间基本属性值表)的数据库操作 Mapper<p/>
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectByIdRoomId(Long id);
}




