package com.xieyv.lighthome.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyv.lighthome.common.exception.LhException;
import com.xieyv.lighthome.common.redis.RedisConstant;
import com.xieyv.lighthome.common.result.ResultCodeEnum;
import com.xieyv.lighthome.common.util.CodeUtils;
import com.xieyv.lighthome.common.util.JwtUtil;
import com.xieyv.lighthome.model.entity.UserInfo;
import com.xieyv.lighthome.model.enums.BaseStatus;
import com.xieyv.lighthome.web.app.mapper.UserInfoMapper;
import com.xieyv.lighthome.web.app.service.LoginService;
import com.xieyv.lighthome.web.app.service.SmsService;
import com.xieyv.lighthome.web.app.vo.user.LoginVo;
import com.xieyv.lighthome.web.app.vo.user.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SmsService smsService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void getCode(String phone) {
        String code = CodeUtils.getRandomCode(6);
        String key = RedisConstant.APP_LOGIN_PREFIX + phone;
        //限制每分钟只能发送一次
        if (stringRedisTemplate.hasKey(key)) {
            Long ttl = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
            if(RedisConstant.APP_LOGIN_CODE_TTL_SEC - ttl < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
                throw new LhException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }
        smsService.sendCode(phone, code); //发送短信验证码
        stringRedisTemplate.opsForValue().set(key, code, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);
    }

    @Override
    public String login(LoginVo loginVo) {
        if(loginVo.getPhone() == null) {
            throw  new LhException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }
        if(loginVo.getCode() == null) {
            throw  new LhException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }
        String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();
        String code = stringRedisTemplate.opsForValue().get(key);
        if(code == null) {
            throw new LhException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        if(!loginVo.getCode().equals(code)) {
            throw new LhException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getPhone, loginVo.getPhone()));
        if(userInfo == null) {
            //新用户注册账号
            userInfo = new UserInfo();
            userInfo.setNickname("lh_" + loginVo.getPhone());
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfoMapper.insert(userInfo);
        }
        else {
            if(userInfo.getStatus() == BaseStatus.DISABLE) {
                throw new LhException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
            }
        }

        return JwtUtil.createJWT(userInfo.getId(), userInfo.getPhone());
    }

    @Override
    public UserInfoVo getInfo(Long id) {
        UserInfo userInfo = userInfoMapper.selectById(id);
        return new UserInfoVo(userInfo.getNickname(), userInfo.getAvatarUrl());
    }
}
