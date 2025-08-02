package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementQueryVo;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementVo;

/**
 * @author xieyv
 * <p>表 lease_agreement(租约信息表)的service<p/>
 */
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    AgreementVo getAgreementVoById(Long id);

    IPage<AgreementVo> getAgreementVoByAgreementQueryVo(Page<AgreementVo> page, AgreementQueryVo queryVo);
}
