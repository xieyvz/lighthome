package com.xieyv.lighthome.web.app.controller.room;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.web.app.service.RoomInfoService;
import com.xieyv.lighthome.web.app.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.app.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.app.vo.room.RoomQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "房间信息")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Autowired
    private RoomInfoService roomInfoService;

    @Operation(summary = "分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current,
                                              @RequestParam long size, RoomQueryVo queryVo) {
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> iPage = roomInfoService.listByQueryVo(page, queryVo);
        return Result.ok(iPage);
    }

    @Operation(summary = "根据id获取房间的详细信息")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo vo = roomInfoService.getDetailById(id);
        return Result.ok(vo);
    }

    @Operation(summary = "根据社区id分页查询房间列表")
    @GetMapping("pageItemByCommunityId")
    public Result<IPage<RoomItemVo>> pageItemByCommunityId(@RequestParam long current, @RequestParam long size,
                                                           @RequestParam Long id) {
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> iPage = roomInfoService.listByRoomId(page, id);
        return Result.ok(iPage);
    }
}
