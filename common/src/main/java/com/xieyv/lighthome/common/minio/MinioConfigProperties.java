package com.xieyv.lighthome.common.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "minio")
public class MinioConfigProperties {
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
