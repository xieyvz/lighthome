package com.xieyv.lighthome.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  @author xieyv
 *  配置minio客户端，用于存储图片
 */
@EnableConfigurationProperties(MinioConfigProperties.class)
@Configuration
public class MinioConfiguration {
    @Autowired
    private MinioConfigProperties minioProperties;

    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder().endpoint(minioProperties.getEndpoint()).
                credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();

    }
}
