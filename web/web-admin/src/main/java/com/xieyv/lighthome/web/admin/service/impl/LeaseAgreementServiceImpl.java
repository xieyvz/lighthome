package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.*;
import com.xieyv.lighthome.web.admin.mapper.*;
import com.xieyv.lighthome.web.admin.service.LeaseAgreementService;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementQueryVo;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * lease_agreement(租约信息表)
 */
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

    @Autowired
    private LeaseAgreementMapper leaseAgreementMapper;
    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;

    @Override
    public AgreementVo getAgreementVoById(Long id) {
        LeaseAgreement leaseAgreement = leaseAgreementMapper.selectById(id);
        CommunityInfo communityInfo = communityInfoMapper.selectById(leaseAgreement.getCommunityId());
        RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreement.getRoomId());
        PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreement.getPaymentTypeId());
        LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreement.getLeaseTermId());
        AgreementVo vo = new AgreementVo();
        BeanUtils.copyProperties(leaseAgreement, vo);
        vo.setCommunityInfo(communityInfo);
        vo.setRoomInfo(roomInfo);
        vo.setPaymentType(paymentType);
        vo.setLeaseTerm(leaseTerm);
        return vo;
    }

    @Override
    public IPage<AgreementVo> getAgreementVoByAgreementQueryVo(Page<AgreementVo> page, AgreementQueryVo queryVo) {
        return leaseAgreementMapper.selectListByAgreementQueryVo(page, queryVo);
    }
}




