package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.BrowsingHistory;
import com.xieyv.lighthome.web.app.vo.history.HistoryItemVo;

/**
* browsing_history(浏览历史)
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {
    IPage<HistoryItemVo> listByUid(Page<HistoryItemVo> page, Long id);
}
