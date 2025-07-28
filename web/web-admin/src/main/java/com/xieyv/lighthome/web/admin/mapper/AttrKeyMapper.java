package com.xieyv.lighthome.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyv.lighthome.model.entity.AttrKey;
import com.xieyv.lighthome.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author xieyv
* <p>表 attr_key(房间基本属性表)的数据库操作 Mapper<p/>
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {
    /**
     *  ListAttrKey 左外连接 ListAttrValue  <br>
     *  用于查询所有房间基本属性 和 其对应的属性值  <br>
     *  即完整的属性信息
     */
    public List<AttrKeyVo> listAttrInfo();
}




