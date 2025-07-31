package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.RoomInfo;
import com.xieyv.lighthome.model.enums.ReleaseStatus;
import com.xieyv.lighthome.web.admin.service.RoomInfoService;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomDetailVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomItemVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomQueryVo;
import com.xieyv.lighthome.web.admin.vo.room.RoomSubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间信息管理")
@RestController
@RequestMapping("/admin/room")
public class RoomController {

    @Autowired
    private RoomInfoService roomInfoService;

    @Operation(summary = "保存或更新房间信息")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdate(@RequestBody RoomSubmitVo roomSubmitVo) {
        roomInfoService.saveOrUpdateInfo(roomSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "根据条件分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current,
                                              @RequestParam long size, RoomQueryVo queryVo) {
        Page<CommunityItemVo> voPage = new Page<>(current, size);
        IPage<RoomItemVo> iPage = roomInfoService.listByQueryVo(voPage, queryVo);
        return Result.ok(iPage);
    }

    @Operation(summary = "根据id获取房间详细信息")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo vo = roomInfoService.getDetailById(id);
        return Result.ok(vo);
    }

    @Operation(summary = "根据id删除房间信息")
    @DeleteMapping("removeById")
    public Result<Void> removeById(@RequestParam Long id) {
        roomInfoService.removeInfoById(id);
        return Result.ok();
    }

    @Operation(summary = "根据id修改房间发布状态")
    @PostMapping("updateReleaseStatusById")
    public Result<Void> updateReleaseStatusById(Long id, ReleaseStatus status) {
        LambdaUpdateWrapper<RoomInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RoomInfo::getId, id);
        updateWrapper.set(RoomInfo::getIsRelease, status);
        roomInfoService.update(updateWrapper);
        return Result.ok();
    }

    @GetMapping("listBasicByApartmentId")
    @Operation(summary = "根据社区id查询房间列表")
    public Result<List<RoomInfo>> listBasicByApartmentId(Long id) {
        LambdaQueryWrapper<RoomInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoomInfo::getCommunityId, id);
        List<RoomInfo> list = roomInfoService.list(queryWrapper);
        return Result.ok(list);
    }

}


















