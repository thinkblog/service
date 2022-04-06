package cn.thinkmoon.blog.core.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="qiniu")
public class QiniuProperty {
    private String accessKey;

    private String secretKey;

    private String bucket;
}
