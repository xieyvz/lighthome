package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementQueryVo;
import com.xieyv.lighthome.web.admin.vo.agreement.AgreementVo;

/**
* @author xieyv
* <p>表 lease_agreement(租约信息表)的数据库操作 Mapper<p/>
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> selectListByAgreementQueryVo(Page<AgreementVo> page, AgreementQueryVo queryVo);
}




