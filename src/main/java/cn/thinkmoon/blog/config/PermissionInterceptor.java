package cn.thinkmoon.blog.config;

import cn.thinkmoon.blog.core.enums.ResultEnum;
import cn.thinkmoon.blog.core.except.CommonException;
import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.modules.pojo.po.UserPO;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Configuration
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    ObjectMapper mapper;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取访问的处理方法上的注解
        Permission annotation = handlerMethod.getMethodAnnotation(Permission.class);
        // 通过拦截器获取到token数据
        String token = request.getHeader("authorization");
        if (StringUtils.hasLength(token)) {
            Claims claims;
            try {
                claims = JWT.parseToken(token);
            } catch (Exception exception) {
                throw new CommonException(ResultEnum.UNAUTHENTICATED);
            }
            // token解析失败抛异常
            if (claims == null) {
                throw new CommonException(ResultEnum.UNAUTHENTICATED);
            }
            int ONE_HOUR_MILLIS = 60 * 60 * 1000;
            int ONE_DAY_MILLIS = 24 * 3600 * 1000;

            // 当token还有一个小时就要过期时，重新刷新过期时间，并写入cookies
            if (claims.getExpiration().getTime() < new Date().getTime() + ONE_HOUR_MILLIS) {
                claims.setExpiration(new Date(new Date().getTime() + ONE_DAY_MILLIS));
                String newToken = JWT.generateToken(claims);
                Cookie cookie = new Cookie("auth", newToken);
                cookie.setDomain("thinkmoon.cn");
                cookie.setPath("/");
                cookie.setMaxAge(ONE_DAY_MILLIS);
                response.addCookie(cookie);
            };
            request.setAttribute("user_info", mapper.convertValue(claims, UserPO.class));
        }

        // 如果需要权限标签
        if (annotation != null) {
            // TODO: 此处以后还需要判断对应的权限标签在用户的权限范围内
            // 没有token则抛出无身份异常
            if (!StringUtils.hasLength(token)) {
                throw new CommonException(ResultEnum.UNAUTHENTICATED);
            }
        }
        return true;
    }
}