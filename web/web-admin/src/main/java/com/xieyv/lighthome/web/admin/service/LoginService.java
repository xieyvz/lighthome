package com.xieyv.lighthome.web.admin.service;

import com.xieyv.lighthome.web.admin.vo.login.CaptchaVo;
import com.xieyv.lighthome.web.admin.vo.login.LoginVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long id);
}
