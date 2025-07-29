package com.xieyv.lighthome.web.admin.service.impl;

import com.xieyv.lighthome.common.minio.MinioConfigProperties;
import com.xieyv.lighthome.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    MinioClient minioClient;
    @Autowired
    MinioConfigProperties minioProperties;

    @Override
    public String upload(MultipartFile file) throws ServerException,
            InsufficientDataException, ErrorResponseException, IOException,
            NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException,
            XmlParserException, InternalException {

        String url = null;

        boolean exists = minioClient.bucketExists(BucketExistsArgs
                .builder().bucket(minioProperties.getBucketName()).build());
        if (!exists) {
            //桶不存在，创建桶和设计权限
            minioClient.makeBucket(MakeBucketArgs.
                    builder().bucket(minioProperties.getBucketName()).build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs
                    .builder().bucket(minioProperties.getBucketName())
                    .config(createBucketPolicyConfig(minioProperties.getBucketName()))
                    .build());
        }
        //存储名称格式> yyyyMMdd/uuid-name
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date())
                + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        minioClient.putObject(PutObjectArgs
                .builder().bucket(minioProperties.getBucketName())
                .stream(file.getInputStream(), file.getSize(), -1)
                .object(fileName)
                .contentType(file.getContentType())
                .build());
        //获取url
        url = minioProperties.getEndpoint() + "/"
                + minioProperties.getBucketName() + "/" + fileName;

        return url;
    }


    private String createBucketPolicyConfig(String bucketName) {
        return """
                {
                "Statement" : [ {
                    "Action" : "s3:GetObject",
                    "Effect" : "Allow",
                    "Principal" : "*",
                    "Resource" : "arn:aws:s3:::%s/*"
                    } ],
                "Version" : "2012-10-17"
                }
               """.formatted(bucketName);
    }
}
