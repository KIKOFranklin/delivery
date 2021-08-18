package com.mochasoft.deliveryweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliverysecurity.jwt.JwtToken;
import com.mochasoft.deliverysecurity.jwt.JwtUtil;
import com.mochasoft.deliveryservice.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 14:03
 * @deprecated 初级测试结束 抛弃此类
 */

@RestController
@RequestMapping("/test")
@Deprecated
@Api(value = "类的描述", tags = {"TestController接口"})
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public String test01(){
        return "Hello World";
    }

    @RequestMapping("/get")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public User test02(){
//        User user = new User();
//        user.setId("1");
//        return userService.findSingleUser(user);
        return null;
    }

    @RequestMapping("/insert")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public String test03(){
        User user = User.builder().
                userName("王家豪").
                userMobile("18855619371").
                build();
        //Active Record用法
        user.insert();

        return "插入成功";
    }

    @RequestMapping("/update")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public String test04(){
        User user = User.builder().build();
//        userService.update(user);
        return "返回成功";
    }


    @RequestMapping("/page")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="name", required = true, dataType = "字符串")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    public List<User> test05(){
//        return userService.findByPage();
        return null;
    }

    @RequestMapping("/login")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public Object test06(String userName, String passWord){
        JSONObject jsonObject = new JSONObject();
        // 检验用户是否存在(为了简单，这里假设用户存在，并制造一个uuid假设为用户id)
        String userId = UUID.randomUUID().toString();
        // 生成签名
        String token= JwtUtil.sign(userId);
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("userName", userName);
        userInfo.put("passWord", passWord);
        jsonObject.put("token", token);
        jsonObject.put("user", userInfo);
        jsonObject.put("code", 200);
        return jsonObject;
    }

    @RequestMapping("/jwt")
    @JwtToken
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public String test07(){
        return "验证成功!";
    }

    @RequestMapping("/info")
    @ApiOperation(value = "方法的描述", notes = "分页查询方法", httpMethod = "GET", response = String.class)
    public String tempUserInfo() {
        return "用户信息!";
    }


}
