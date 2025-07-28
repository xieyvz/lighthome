package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.BrowsingHistory;
import com.xieyv.lighthome.web.app.mapper.BrowsingHistoryMapper;
import com.xieyv.lighthome.web.app.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

/**
 *  针对表【browsing_history(浏览历史)
 */
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
}