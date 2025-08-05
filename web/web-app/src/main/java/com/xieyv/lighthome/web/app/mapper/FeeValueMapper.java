package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.FeeValue;
import com.xieyv.lighthome.web.app.vo.fee.FeeValueVo;

import java.util.List;


/**
*   fee_value(杂项费用值表)
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListVoByRoomId(Long id);
}




