package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.core.enums.PermissionTag;
import cn.thinkmoon.blog.modules.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping(value = "/send")
    @Permission(permissionTag = PermissionTag.ADMIN)
    public int send(@org.jetbrains.annotations.NotNull @RequestBody Map params) {
        try {
            emailService.sendMail((String) params.get("to"), (String) params.get("subject"), (String) params.get("text"));
        } catch (MessagingException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
