package com.xieyv.lighthome.web.app.service;

import com.xieyv.lighthome.web.app.vo.user.LoginVo;
import com.xieyv.lighthome.web.app.vo.user.UserInfoVo;

public interface LoginService {

    void getCode(String phone);

    String login(LoginVo loginVo);

    UserInfoVo getInfo(Long id);
}
