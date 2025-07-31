package com.xieyv.lighthome.web.admin.controller.community;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.model.entity.AttrKey;
import com.xieyv.lighthome.model.entity.AttrValue;
import com.xieyv.lighthome.web.admin.service.AttrKeyService;
import com.xieyv.lighthome.web.admin.service.AttrValueService;
import com.xieyv.lighthome.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间属性管理")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {
    @Autowired
    AttrKeyService attrKeyService;
    @Autowired
    AttrValueService attrValueService;

    @Operation(summary = "新增或更新属性名称")
    @PostMapping("key/saveOrUpdate")
    public Result<Void> saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        attrKeyService.saveOrUpdate(attrKey);
        return Result.ok();
    }

    @Operation(summary = "新增或更新属性值")
    @PostMapping("value/saveOrUpdate")
    public Result<Void> saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }


    @Operation(summary = "查询全部属性名称和属性值列表")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
        List<AttrKeyVo> attrKeyVos = attrKeyService.listAttrInfo();
        return Result.ok(attrKeyVos);
    }

    @Transactional(rollbackFor = Exception.class)
    @Operation(summary = "根据id删除属性名称")
    @DeleteMapping("key/deleteById")
    public Result<Void> removeAttrKeyById(@RequestParam Long attrKeyId) {
        //删除属性key
        attrKeyService.removeById(attrKeyId);
        //删除该key对应的所有属性value
        LambdaQueryWrapper<AttrValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AttrValue::getAttrKeyId, attrKeyId);
        attrValueService.remove(queryWrapper);
        return Result.ok();
    }

    @Operation(summary = "根据id删除属性值")
    @DeleteMapping("value/deleteById")
    public Result<Void> removeAttrValueById(@RequestParam Long id) {
        attrValueService.removeById(id);
        return Result.ok();
    }

}
