package com.xieyv.lighthome.web.app.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.RoomInfo;
import com.xieyv.lighthome.web.app.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.app.vo.room.RoomQueryVo;

import java.math.BigDecimal;


/**
*   room_info(房间信息表)
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    BigDecimal selectMinRentByCommunityId(Long id);

    IPage<RoomItemVo> selectByQueryVo(Page<RoomItemVo> page, RoomQueryVo queryVo);

    IPage<RoomItemVo> selectByRoomId(Page<RoomItemVo> page, Long id);
}