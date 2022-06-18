package cn.thinkmoon.blog.core.base;

import cn.thinkmoon.blog.core.enums.ResultEnum;
import cn.thinkmoon.blog.core.except.CommonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(final MethodParameter returnType, final Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getGenericParameterType().equals(ResponseResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return body;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e.getClass() == CommonException.class) {
            CommonException ce = (CommonException) e;
            response.setStatus(ce.getResultCode().code());
            return new ResponseResult(ce.getResultCode());
        } else {
            // 本地打印错误信息
            e.printStackTrace();
            // 客户端反馈友好错误信息
            return new ResponseResult(ResultEnum.SERVER_ERROR);
        }
    }
}
