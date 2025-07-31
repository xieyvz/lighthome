package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.RoomInfo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomQueryVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomSubmitVo;

/**
* @author xieyv
* <p>表 room_info(房间信息表)的数据库操作 Mapper<p/>
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {


    IPage<RoomItemVo> listByQueryVo(Page<CommunityItemVo> voPage, RoomQueryVo queryVo);
}




