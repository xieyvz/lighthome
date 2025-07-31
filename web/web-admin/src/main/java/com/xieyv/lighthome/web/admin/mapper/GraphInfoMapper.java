package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.GraphInfo;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;

import java.util.List;


/**
* @author xieyv
* <p>表 graph_info(图片信息表)的数据库操作 Mapper<p/>
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




