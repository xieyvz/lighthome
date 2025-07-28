package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.FeeKey;
import com.xieyv.lighthome.web.admin.vo.fee.FeeKeyVo;

import java.util.List;


/**
 * @author xieyv
 * <p>表 fee_key(杂项费用名称表)的service<p/>
 */
public interface FeeKeyService extends IService<FeeKey> {

    List<FeeKeyVo> listFeeInfo();
}
