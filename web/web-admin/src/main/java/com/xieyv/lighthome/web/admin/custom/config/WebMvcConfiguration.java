package com.xieyv.lighthome.web.admin.custom.config;

import com.xieyv.lighthome.web.admin.custom.converter.StringToEnumTypeConverterFactory;
import com.xieyv.lighthome.web.admin.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  @author xieyv
 *  <p>WebMvc配置类</p>
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /*
    @Deprecated
    @Autowired
    private StringToItemTypeConverter stringToItemTypeConverter;
    */

    @Autowired
    private StringToEnumTypeConverterFactory stringToEnumTypeConverterFactory;

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(this.stringToItemTypeConverter); //将转换器StringToItemTypeConverter注册
        registry.addConverterFactory(this.stringToEnumTypeConverterFactory);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
    }
}
