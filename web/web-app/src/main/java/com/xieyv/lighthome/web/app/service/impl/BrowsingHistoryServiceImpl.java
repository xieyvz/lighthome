package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.BrowsingHistory;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.mapper.BrowsingHistoryMapper;
import com.xieyv.lighthome.web.app.mapper.GraphInfoMapper;
import com.xieyv.lighthome.web.app.service.BrowsingHistoryService;
import com.xieyv.lighthome.web.app.vo.history.HistoryItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  针对表【browsing_history(浏览历史)
 */
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {

    @Autowired
    private BrowsingHistoryMapper browsingHistoryMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Override
    public IPage<HistoryItemVo> listByUid(Page<HistoryItemVo> page, Long id) {
        IPage<HistoryItemVo> vos = browsingHistoryMapper.selectVoList(page, id);
        vos.getRecords().forEach(item -> {
            item.setRoomGraphVoList(graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, item.getRoomId()));
        });
        return vos;
    }
}