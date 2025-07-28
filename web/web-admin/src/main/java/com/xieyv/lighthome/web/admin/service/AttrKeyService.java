package com.xieyv.lighthome.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.AttrKey;
import com.xieyv.lighthome.web.admin.vo.attr.AttrKeyVo;

import java.util.List;


/**
 * @author xieyv
 *<p>表 attr_key(房间基本属性表) 的service<p/>
 */
public interface AttrKeyService extends IService<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}
