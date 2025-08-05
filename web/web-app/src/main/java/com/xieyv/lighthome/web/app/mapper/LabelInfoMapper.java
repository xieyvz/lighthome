package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.LabelInfo;

import java.util.List;


/**
*   label_info(标签信息表)
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> selectListByCommunityId(Long id);

    List<LabelInfo> selectListByRoomId(Long id);
}




