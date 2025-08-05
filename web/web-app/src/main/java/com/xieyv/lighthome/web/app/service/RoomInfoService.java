package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.RoomInfo;
import com.xieyv.lighthome.web.app.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.app.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.app.vo.room.RoomQueryVo;

/**
*   room_info(房间信息表)
*/
public interface RoomInfoService extends IService<RoomInfo> {

    IPage<RoomItemVo> listByQueryVo(Page<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

    IPage<RoomItemVo> listByRoomId(Page<RoomItemVo> page, Long id);
}
