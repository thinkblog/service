package cn.thinkmoon.blog.utils;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Qiniu {
    private Qiniu() {}

    private static String accessKey;

    private static String secretKey;

    private static String bucket;

    @Value("${qiniu.accessKey}")
    public void setAccessKey(String accessKey) {
        Qiniu.accessKey = accessKey;
    }

    @Value("${qiniu.secretKey}")
    public void setSecretKey(String secretKey) {
        Qiniu.secretKey = secretKey;
    }

    @Value("${qiniu.bucket}")
    public void setBucket(String bucket) {
        Qiniu.bucket = bucket;
    }

    public static String generateCode(){
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }
}
