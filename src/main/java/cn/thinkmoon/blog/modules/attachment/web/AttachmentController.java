package cn.thinkmoon.blog.modules.attachment.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

    @RequestMapping(value = "/upload_code")
    public String getUploadCode(){

        return "";
    }
}
