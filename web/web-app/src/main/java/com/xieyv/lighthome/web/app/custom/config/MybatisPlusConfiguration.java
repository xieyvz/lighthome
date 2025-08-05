package com.xieyv.lighthome.web.app.custom.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xieyv.lighthome.web.app.mapper")
public class MybatisPlusConfiguration {

}
