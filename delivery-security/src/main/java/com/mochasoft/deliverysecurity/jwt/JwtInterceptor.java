package com.mochasoft.deliverysecurity.jwt;

import com.mochasoft.deliverycore.exception.TokenValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 9:53
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(JwtToken.class)) {
            JwtToken jwtToken = method.getAnnotation(JwtToken.class);
            if (jwtToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new TokenValidateException("登录信息已失效，请重新登录！");
                }
                // 获取 token 中的 userId
                String userId = JwtUtil.getUserId(token);
                log.info("userId{}", userId);
                // 验证 token
                JwtUtil.checkSign(token);
            }
        }
        return true;
    }
}
