package cn.thinkmoon.blog.config;

import cn.thinkmoon.blog.core.enums.PermissionTag;
import cn.thinkmoon.blog.core.enums.ResultEnum;
import cn.thinkmoon.blog.core.except.CommonException;
import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.content.pojo.po.UserPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import cn.thinkmoon.blog.utils.JWT;

import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    ObjectMapper mapper;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        log.info("进入拦截器" + request.getServletPath());
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取访问的处理方法上的注解
        Permission annotation = handlerMethod.getMethodAnnotation(Permission.class);

        // 去判断处理方法上是否贴了自定义注解
        if (annotation == null) {
            log.info("不需要权限");
            return true;
        } else {
            if (annotation.permissionTag() == PermissionTag.ADMIN) {
                log.info("标签相等");
                // 通过拦截器获取到token数据
                String token = request.getHeader("Authorization");
                log.info(token);
                // 没有token则抛出无身份异常
                if (StringUtils.hasLength(token)) {
                    log.info("有");
                    Claims claims;
                    try {
                        claims = JWT.parseToken(token);
                    } catch (Exception exception) {
                        // 如果捕获异常则token解析失败，抛出无身份异常
                        exception.printStackTrace();
                        throw new CommonException(ResultEnum.UNAUTHENTICATED);
                    }
                    // token解析成功
                    if (claims != null) {
                        request.setAttribute("user_info", mapper.convertValue(claims, UserPO.class));
                        return true;
                    }
                } else {
                    throw new CommonException(ResultEnum.UNAUTHENTICATED);
                }
            }
        }
        return false;
    }
}