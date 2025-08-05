package com.xieyv.lighthome.web.app.controller.community;

import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.web.app.service.CommunityInfoService;
import com.xieyv.lighthome.web.app.vo.community.CommunityDetailVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "社区信息")
@RequestMapping("/app/community")
public class CommunityController {

    @Autowired
    private CommunityInfoService communityInfoService;

    @Operation(summary = "根据id获取社区信息")
    @GetMapping("getDetailById")
    public Result<CommunityDetailVo> getDetailById(@RequestParam Long id) {
        CommunityDetailVo vo = communityInfoService.getDetailById(id);
        return Result.ok(vo);
    }
}
