package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.core.enums.PermissionTag;
import cn.thinkmoon.blog.modules.service.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @Permission(permissionTag = PermissionTag.ADMIN)
    @GetMapping(value = "/upload_code")
    public String getUploadCode(){
        return attachmentService.generateUploadCode();
    }
}
