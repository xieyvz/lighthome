package com.xieyv.lighthome.web.app.controller.login;

import com.xieyv.lighthome.common.login.LoginUserHolder;
import com.xieyv.lighthome.common.result.Result;
import com.xieyv.lighthome.web.app.service.LoginService;
import com.xieyv.lighthome.web.app.vo.user.LoginVo;
import com.xieyv.lighthome.web.app.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "登录管理")
@RestController
@RequestMapping("/app/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login/getCode")
    @Operation(summary = "获取短信验证码")
    public Result<Void> getCode(@RequestParam String phone) {
        loginService.getCode(phone);
        return Result.ok();
    }

    @PostMapping("login")
    @Operation(summary = "登录")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }

    @GetMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<UserInfoVo> info() {
        Long id = LoginUserHolder.getLoginUser().getUid();
        UserInfoVo userInfoVo = loginService.getInfo(id);
        return Result.ok(userInfoVo);
    }
}