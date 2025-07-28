package com.xieyv.lighthome.web.admin.custom.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *  @author xieyv
 *  <p>扫描所有mapper</p>
 */
@Configuration
@MapperScan("com.xieyv.lighthome.web.admin.mapper")
public class MybatisPlusConfiguration {

}