package com.xieyv.lighthome.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xieyv.lighthome.model.entity.LeaseTerm;

import java.util.List;

/**
*   @author xieyv
 *   租期相关接口
*/
public interface LeaseTermService extends IService<LeaseTerm> {

    List<LeaseTerm> listByRoomId(Long id);
}
