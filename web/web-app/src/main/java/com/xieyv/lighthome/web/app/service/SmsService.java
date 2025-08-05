package com.xieyv.lighthome.web.app.service;

public interface SmsService {
    void sendCode(String phone, String code);
}
