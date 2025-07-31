package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.RoomInfo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomQueryVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomSubmitVo;

/**
 * @author xieyv
 *<p>表 room_info(房间信息表)的service<p/>
 */
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateInfo(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> listByQueryVo(Page<CommunityItemVo> voPage, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

    void removeInfoById(Long id);
}
