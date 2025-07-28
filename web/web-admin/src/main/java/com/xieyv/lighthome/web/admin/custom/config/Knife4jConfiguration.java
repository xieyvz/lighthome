package com.xieyv.lighthome.web.admin.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("后台管理系统api")
                .version("1.0")
                .description("后台管理系api"));
    }

    @Bean
    public GroupedOpenApi systemAPI() {
        return GroupedOpenApi.builder()
                .group("系统信息管理")
                .pathsToMatch("/admin/system/**").build();
    }

    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder()
                .group("后台登陆管理")
                .pathsToMatch("/admin/login/**", "/admin/info").build();
    }

    @Bean
    public GroupedOpenApi communityAPI() {

        return GroupedOpenApi.builder()
                .group("社区信息管理")
                .pathsToMatch(
                        "/admin/community/**",
                        "/admin/room/**",
                        "/admin/label/**",
                        "/admin/facility/**",
                        "/admin/fee/**",
                        "/admin/attr/**",
                        "/admin/payment/**",
                        "/admin/region/**",
                        "/admin/term/**",
                        "/admin/file/**"
                ).build();
    }
    @Bean
    public GroupedOpenApi leaseAPI() {
        return GroupedOpenApi.builder()
                .group("租赁信息管理")
                .pathsToMatch(
                        "/admin/appointment/**",
                        "/admin/agreement/**"
                ).build();
    }
    @Bean
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("平台用户管理").
                pathsToMatch("/admin/user/**").build();
    }
}
