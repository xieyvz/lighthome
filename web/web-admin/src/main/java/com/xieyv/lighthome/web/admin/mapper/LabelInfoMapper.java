package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.LabelInfo;

import java.util.List;

/**
* @author xieyv
* <p>表 label_info(标签信息表)的数据库操作 Mapper<p/>
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> selectListByCommunityId(Long id);

    List<LabelInfo> selectListByRoomId(Long id);
}




