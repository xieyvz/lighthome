package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xieyv.lighthome.model.entity.AttrKey;
import com.xieyv.lighthome.web.admin.mapper.AttrKeyMapper;
import com.xieyv.lighthome.web.admin.service.AttrKeyService;
import com.xieyv.lighthome.web.admin.vo.attr.AttrKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* attr_key(房间基本属性表)
*/
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService {

    @Autowired
    private AttrKeyMapper attrKeyMapper;

    @Override
    public List<AttrKeyVo> listAttrInfo() {
        return attrKeyMapper.listAttrInfo();
    }
}




