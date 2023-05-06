package com.imooc.ad.advice;


import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//实现对请求进行拦截处理，之后返回
//主要就是把请求全部装在到vo层里面
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {

    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        判断拦截的条件，如果被注解ignore就不去拦截，返回false，其余都是要拦截
//        类被注解或者方法被注解，直接false
        if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }

        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    @Override
    @Nullable
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        具体的处理逻辑，就是把o复制到data里面，首先判断o
//        首先强转o
        CommonResponse<Object> response= new CommonResponse<>(0,"");
        if(null==o){
            return response;
        }else if(o instanceof CommonResponse){
            response =(CommonResponse<Object>) o;
        }else{
            response.setData(o);
        }

        return response;
    }
}
