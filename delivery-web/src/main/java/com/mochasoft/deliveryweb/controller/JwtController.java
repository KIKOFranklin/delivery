package com.mochasoft.deliveryweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mochasoft.deliverycore.exception.ServiceException;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliverysecurity.jwt.JwtUtil;
import com.mochasoft.deliveryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangjiahao
 * @since 2021/8/18 10:43 下午
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private UserService userService;


    @PostMapping("/login/{username}/{password}")
    public ResponseData<String> login(@PathVariable final String username,
                                      @PathVariable final String password){
        User authenticateUser = userService.getOne(
                 new QueryWrapper<User>()
                .eq("USER_NAME", username)
                .eq("USER_PWD", password)
        );
        if(Objects.isNull(authenticateUser)){
            throw new ServiceException("用户名或密码错误!");
        } else {
            String token= JwtUtil.sign(authenticateUser.getId());
            return ResponseData.success(token);
        }
    }
}
