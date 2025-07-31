package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.enums.ReleaseStatus;
import com.xieyv.lighthome.web.admin.service.CommunityInfoService;
import com.xieyv.lighthome.web.admin.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityQueryVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "社区信息管理")
@RestController
@RequestMapping("/admin/community")
public class CommunityController {

    @Autowired
    private CommunityInfoService infoService;

    @Operation(summary = "保存或更新社区信息")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdate(@RequestBody CommunitySubmitVo communitySubmitVo) {
        infoService.saveOrUpdateInfo(communitySubmitVo);
        return Result.ok();
    }

    /**
     *   根据省市区查询合适的社区
     */
    @Operation(summary = "根据条件分页查询社区列表")
    @GetMapping("pageItem")
    public Result<IPage<CommunityItemVo>> pageItem(@RequestParam long current,
                                                   @RequestParam long size,
                                                   CommunityQueryVo queryVo) {
        Page<CommunityItemVo> voPage = new Page<>(current, size);
        IPage<CommunityItemVo> list = infoService.listByQueryVo(voPage, queryVo);

        return Result.ok(list);
    }

    @Operation(summary = "根据ID获取社区详细信息")
    @GetMapping("getDetailById")
    public Result<CommunityDetailVo> getDetailById(@RequestParam Long id) {
        CommunityDetailVo detailVo = infoService.getDetailById(id);
        return Result.ok(detailVo);
    }

    @Operation(summary = "根据id删除社区信息")
    @DeleteMapping("removeById")
    public Result<Void> removeById(@RequestParam Long id) {
        infoService.removeInfoById(id);
        return Result.ok();
    }

    @Operation(summary = "根据id修改社区发布状态")
    @PostMapping("updateReleaseStatusById")
    public Result<Void> updateReleaseStatusById(@RequestParam Long id,
                                                @RequestParam ReleaseStatus status) {
        LambdaUpdateWrapper<CommunityInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(CommunityInfo::getId, id);
        updateWrapper.set(CommunityInfo::getIsRelease, status);
        infoService.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "根据区县id查询社区信息列表")
    @GetMapping("listInfoByDistrictId")
    public Result<List<CommunityInfo>> listInfoByDistrictId(@RequestParam Long id) {
        LambdaQueryWrapper<CommunityInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommunityInfo::getDistrictId, id);
        List<CommunityInfo> list = infoService.list(queryWrapper);
        return Result.ok(list);
    }
}














