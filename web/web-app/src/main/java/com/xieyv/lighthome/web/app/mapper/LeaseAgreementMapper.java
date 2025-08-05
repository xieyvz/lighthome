package com.xieyv.lighthome.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementDetailVo;
import com.xieyv.lighthome.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
*   lease_agreement(租约信息表)
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    List<AgreementItemVo> listItem();

    AgreementDetailVo getDetailById(Long id);
}




