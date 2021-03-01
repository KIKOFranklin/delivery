package com.mochasoft.deliveryweb.controller;

import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliveryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 14:03
 */
@RestController
public class TestController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/index")
    public String test01(){
        return "Hello World";
    }

    @RequestMapping("/get")
    public User test02(){
        User user = new User();
        user.setId("1");
        return userService.findSingleUser(user);
    }

    @RequestMapping("/insert")
    public String test03(){
        User user = new User();
        user.setId("3");
        user.setName("Dave");
        user.setPwd("123");
        //Active Record用法
        user.insert();
        return "返回成功";
    }

    @RequestMapping("/update")
    public String test04(){
        User user = new User();
        user.setId("1");
        user.setName("xupengfei");
        userService.update(user);
        return "返回成功";
    }

    @RequestMapping("/page")
    public List<User> test05(){
        return userService.findByPage();
    }

}
