package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.FeeKey;
import com.xieyv.lighthome.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

/**
* @author xieyv
* <p>表 fee_key(杂项费用名称表)的数据库操作 Mapper<p/>
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> listFeeInfo();
}




