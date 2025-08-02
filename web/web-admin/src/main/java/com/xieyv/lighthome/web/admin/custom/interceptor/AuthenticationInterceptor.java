package com.xieyv.lighthome.web.admin.custom.interceptor;

import com.xieyv.lighthome.common.login.LoginUser;
import com.xieyv.lighthome.common.login.LoginUserHolder;
import com.xieyv.lighthome.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *  @author xieyv
 *  拦截器，检查用户登陆状态
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("access-token");   //获取jwt token
        Claims claims = JwtUtil.parseJWT(token);
        Long uid = claims.get("uid", Long.class);
        String username = claims.get("username", String.class);
        LoginUserHolder.setLoginUser(new LoginUser(uid, username));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求处理后调用
        LoginUserHolder.clear();
    }
}
