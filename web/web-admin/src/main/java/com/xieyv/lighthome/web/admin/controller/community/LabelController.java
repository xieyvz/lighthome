package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.LabelInfo;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.admin.service.LabelInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//test acc
@Tag(name = "标签管理")
@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    LabelInfoService labelInfoService;

    @Operation(summary = "（根据类型）查询标签列表")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<LabelInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null, LabelInfo::getType, type) ;
        List<LabelInfo> list = labelInfoService.list(queryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "新增或修改标签信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        labelInfoService.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "根据id删除标签信息")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        labelInfoService.removeById(id);
        return Result.ok();
    }
}
