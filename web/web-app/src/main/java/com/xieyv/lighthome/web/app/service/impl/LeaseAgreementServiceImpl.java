package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.model.enums.ItemType;
import com.xieyv.lighthome.web.app.mapper.GraphInfoMapper;
import com.xieyv.lighthome.web.app.mapper.LeaseAgreementMapper;
import com.xieyv.lighthome.web.app.service.GraphInfoService;
import com.xieyv.lighthome.web.app.service.LeaseAgreementService;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementDetailVo;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementItemVo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  lease_agreement(租约信息表)
 */
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

    @Autowired
    private LeaseAgreementMapper leaseAgreementMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Override
    public List<AgreementItemVo> listItem() {
        List<AgreementItemVo> itemVos = leaseAgreementMapper.listItem();
        itemVos.forEach(item -> {
            String roomId = item.getRoomNumber();
            String[] split = roomId.split(",");
            item.setRoomNumber(split[0]);
            roomId = split[1];
            List<GraphVo> graphVos = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, Long.parseLong(roomId));
            item.setRoomGraphVoList(graphVos);
        });
        return itemVos;
    }

    @Override
    public AgreementDetailVo getDetailById(Long id) {
        AgreementDetailVo detail = leaseAgreementMapper.getDetailById(id);
        List<GraphVo> graphVosC = graphInfoMapper.selectListByItemTypeAndId(ItemType.COMMUNITY, detail.getCommunityId());
        List<GraphVo> graphVosR = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, detail.getRoomId());
        detail.setCommunityGraphVoList(graphVosC);
        detail.setRoomGraphVoList(graphVosR);
        return detail;
    }
}




