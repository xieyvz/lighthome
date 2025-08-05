package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.AttrValue;
import com.xieyv.lighthome.web.app.vo.attr.AttrValueVo;

import java.util.List;


/**
*   attr_value(房间基本属性值表)
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectVoListByRoomId(Long id);
}




