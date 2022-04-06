package cn.thinkmoon.blog.utils;

import cn.thinkmoon.blog.core.property.QiniuProperty;
import com.qiniu.util.Auth;

public class QiniuUtils {

    public static String generateUploadCode(QiniuProperty property){
        Auth auth = Auth.create(property.getAccessKey(), property.getSecretKey());
        return auth.uploadToken(property.getBucket());
    }
}
