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
    public Object beforeBodyWrite(final Object body, final MethodParameter returnType, final MediaType selectedContentType,
                                  final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  final ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null || body instanceof ResponseResult) {
            return body;
        }
        final ResponseResult responseResult = new ResponseResult(body);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(responseResult);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("将 Response 对象序列化为 json 字符串时发生异常", e);
            }
        }
        return responseResult;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.info("error");
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
