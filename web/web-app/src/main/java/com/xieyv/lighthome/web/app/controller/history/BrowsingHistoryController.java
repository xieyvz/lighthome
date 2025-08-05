package com.xieyv.lighthome.web.app.controller.history;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.common.login.LoginUser;
import com.xieyv.lighthome.common.login.LoginUserHolder;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.web.app.service.BrowsingHistoryService;
import com.xieyv.lighthome.web.app.vo.history.HistoryItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "浏览历史管理")
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    @Autowired
    private BrowsingHistoryService browsingHistoryService;

    @Operation(summary = "获取浏览历史")
    @GetMapping("pageItem")
    private Result<IPage<HistoryItemVo>> page(@RequestParam long current, @RequestParam long size) {
        LoginUser loginUser = LoginUserHolder.getLoginUser();
        Page<HistoryItemVo> page = new Page<>(current, size);
        IPage<HistoryItemVo> vo = browsingHistoryService.listByUid(page, loginUser.getUid());
        return Result.ok(vo);
    }
}
