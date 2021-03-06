package cn.thinkmoon.blog.modules.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import cn.thinkmoon.blog.core.base.ResponseResult;
import cn.thinkmoon.blog.modules.pojo.po.UserPO;
import cn.thinkmoon.blog.utils.JWT;
import cn.thinkmoon.blog.modules.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public ResponseResult Login(@RequestBody Map params) throws JsonProcessingException {
        String account = (String) params.get("account");
        String password = (String) params.get("password");
        UserPO user = userService.queryUserByAccount(account);
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if(result.verified){
            Map<String,Object> map = objectMapper.convertValue(user, new TypeReference<Map<String, Object>>() {});
            return new ResponseResult(JWT.generateToken(user.getId().toString(),map));
        }
        return new ResponseResult("登录失败");
    }
}
