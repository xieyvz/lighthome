package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.BrowsingHistory;
import com.xieyv.lighthome.web.app.vo.history.HistoryItemVo;

/**
*   browsing_history(浏览历史)
*/
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    IPage<HistoryItemVo> selectVoList(Page<HistoryItemVo> page, Long id);
}




