package com.xieyv.lighthome.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wf.captcha.SpecCaptcha;
import com.xieyv.lighthome.common.exception.LhException;
import com.xieyv.lighthome.common.redis.RedisConstant;
import com.xieyv.lighthome.common.result.ResultCodeEnum;
import com.xieyv.lighthome.common.util.JwtUtil;
import com.xieyv.lighthome.model.entity.SystemUser;
import com.xieyv.lighthome.model.enums.BaseStatus;
import com.xieyv.lighthome.web.admin.mapper.SystemUserMapper;
import com.xieyv.lighthome.web.admin.service.LoginService;
import com.xieyv.lighthome.web.admin.vo.login.CaptchaVo;
import com.xieyv.lighthome.web.admin.vo.login.LoginVo;
import com.xieyv.lighthome.web.admin.vo.system.user.SystemUserInfoVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *  @author xieyv
 *  用于实现登录的service层代码
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SystemUserMapper systemUserMapper;

    /**
     *  获取验证码
     */
    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String verCode = specCaptcha.text().toLowerCase();
        String key = RedisConstant.ADMIN_LOGIN_PREFIX   + UUID.randomUUID();
        stringRedisTemplate.opsForValue().set(key, verCode,
                RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC * 10, TimeUnit.SECONDS);

        return new CaptchaVo(specCaptcha.toBase64(), key);
    }

    @Override
    public String login(LoginVo loginVo) {
        //检验传入验证码是否为空
        if(loginVo.getCaptchaCode() == null){
            throw new LhException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        //检验验证码是否过期
        String code = stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        if(code == null){
            throw new LhException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }
        //检验验证码是否正确
        if(!code.equals((loginVo.getCaptchaCode()))) {
            throw new LhException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }
        //检验用户名是否存在
        SystemUser user = systemUserMapper.selectOne(
                new LambdaQueryWrapper<SystemUser>()
                        .eq(SystemUser::getUsername, loginVo.getUsername()));
        if(user == null){
            throw new LhException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        //检验用户是否被封禁
        if(user.getStatus() == BaseStatus.DISABLE){
            throw new LhException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }
        //检验密码是否匹配
        if(!DigestUtils.md5Hex(loginVo.getPassword()).equals(user.getPassword())){
            throw new LhException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        return JwtUtil.createJWT(user.getId(), user.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getUsername());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}
