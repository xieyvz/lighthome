package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementDetailVo;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementItemVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*   lease_agreement(租约信息表)
*/

public interface LeaseAgreementService extends IService<LeaseAgreement> {
    List<AgreementItemVo> listItem();

    AgreementDetailVo getDetailById(Long id);
}
