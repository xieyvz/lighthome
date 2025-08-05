package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.GraphInfo;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;

import java.util.List;


/**
*   graph_info(图片信息表)
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




