package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.FeeKey;
import com.xieyv.lighthome.web.admin.mapper.FeeKeyMapper;
import com.xieyv.lighthome.web.admin.service.FeeKeyService;
import com.xieyv.lighthome.web.admin.vo.fee.FeeKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService {

    @Autowired
    FeeKeyMapper feeKeyMapper;

    @Override
    public List<FeeKeyVo> listFeeInfo() {
        return feeKeyMapper.listFeeInfo();
    }
}




