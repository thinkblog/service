package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.core.property.QiniuProperty;
import cn.thinkmoon.blog.utils.QiniuUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttachmentService {

    @Resource
    private QiniuProperty qiniuProperty;

    public String generateUploadCode(){
        return QiniuUtils.generateUploadCode(qiniuProperty);
    }
}
