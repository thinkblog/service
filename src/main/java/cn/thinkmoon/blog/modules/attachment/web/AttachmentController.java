package cn.thinkmoon.blog.modules.attachment.web;

import cn.thinkmoon.blog.modules.attachment.service.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = "/upload_code")
    public String getUploadCode(){
        return attachmentService.generateUploadCode();
    }
}
