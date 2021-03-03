package com.mochasoft.deliverysecurity.jwt;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 14:00
 */
public class ObssoInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        return hasTokenInCookies(httpServletRequest.getCookies());
    }

    /**
     * 判断请求中是否包含OBSSOCookie
     * @param cookies 请求中的cookie
     * @return  boolean值
     */
    private boolean hasTokenInCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (equalsIgnoreCase(cookie.getName(), "ObSSOCookie")) {
                    return true;
                }
            }
        }
        return false;
    }
}
