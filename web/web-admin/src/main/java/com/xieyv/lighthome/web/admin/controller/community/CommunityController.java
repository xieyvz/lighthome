package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.enums.ReleaseStatus;
import com.xieyv.lighthome.web.admin.custom.annocation.NotImplementedX;
import com.xieyv.lighthome.web.admin.service.CommunityFacilityService;
import com.xieyv.lighthome.web.admin.service.CommunityFeeValueService;
import com.xieyv.lighthome.web.admin.service.CommunityInfoService;
import com.xieyv.lighthome.web.admin.service.CommunityLabelService;
import com.xieyv.lighthome.web.admin.vo.community.CommunityDetailVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityItemVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunityQueryVo;
import com.xieyv.lighthome.web.admin.vo.community.CommunitySubmitVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NotImplementedX
@Tag(name = "社区信息管理")
@RestController
@RequestMapping("/admin/apartment")
public class CommunityController {

    @Autowired
    CommunityFacilityService facilityService;
    @Autowired
    CommunityFeeValueService feeValueService;
    @Autowired
    CommunityInfoService InfoService;
    @Autowired
    CommunityLabelService labelService;

    @Operation(summary = "保存或更新社区信息")
    @PostMapping("saveOrUpdate")
    public Result<Void> saveOrUpdate(@RequestBody CommunitySubmitVo communitySubmitVo) {
        InfoService.saveOrUpdateInfo(communitySubmitVo);
        return Result.ok();
    }

    @Operation(summary = "根据条件分页查询社区列表")
    @GetMapping("pageItem")
    public Result<IPage<CommunityItemVo>> pageItem(@RequestParam long current,
                                                   @RequestParam long size, CommunityQueryVo queryVo) {
        return Result.ok();
    }

    @Operation(summary = "根据ID获取社区详细信息")
    @GetMapping("getDetailById")
    public Result<CommunityDetailVo> getDetailById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "根据id删除社区信息")
    @DeleteMapping("removeById")
    public Result<Void> removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "根据id修改社区发布状态")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        return Result.ok();
    }

    @Operation(summary = "根据区县id查询社区信息列表")
    @GetMapping("listInfoByDistrictId")
    public Result<List<CommunityInfo>> listInfoByDistrictId(@RequestParam Long id) {
        return Result.ok();
    }
}














