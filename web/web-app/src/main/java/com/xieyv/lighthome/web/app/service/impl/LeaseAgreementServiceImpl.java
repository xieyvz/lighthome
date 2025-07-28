package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.app.mapper.LeaseAgreementMapper;
import com.xieyv.lighthome.web.app.service.LeaseAgreementService;
import org.springframework.stereotype.Service;

/**
 *  lease_agreement(租约信息表)
 */
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {

}




