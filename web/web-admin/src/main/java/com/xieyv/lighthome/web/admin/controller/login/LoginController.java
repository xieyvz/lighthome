package com.xieyv.lighthome.web.admin.controller.login;

import com.xieyv.lighthome.common.login.LoginUserHolder;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.common.util.JwtUtil;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.web.admin.custom.annocation.NotImplementedX;
import com.xieyv.lighthome.web.admin.service.LoginService;
import com.xieyv.lighthome.web.admin.vo.login.CaptchaVo;
import com.xieyv.lighthome.web.admin.vo.login.LoginVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserInfoVo;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@NotImplementedX
@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo vo = loginService.getCaptcha();
        return Result.ok(vo);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        Long id = LoginUserHolder.getLoginUser().getUid();
        SystemUserInfoVo vo = loginService.getLoginUserInfoById(id);
        return Result.ok(vo);
    }
}