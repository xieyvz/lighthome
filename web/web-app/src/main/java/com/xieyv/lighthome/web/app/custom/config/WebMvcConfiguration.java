package com.xieyv.lighthome.web.app.custom.config;

import com.xieyv.lighthome.web.app.custom.converter.StringToEnumTypeConverterFactory;
import com.xieyv.lighthome.web.app.custom.intercreptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    StringToEnumTypeConverterFactory stringToEnumTypeConverterFactory;
    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.stringToEnumTypeConverterFactory);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/app/**").excludePathPatterns("/app/login/**");
    }
}
