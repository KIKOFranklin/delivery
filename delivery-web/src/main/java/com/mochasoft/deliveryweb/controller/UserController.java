package com.mochasoft.deliveryweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliveryservice.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author KIKOFranklin
 * @create 2021/3/11 0011 17:17
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息接口", tags = {"UserController接口"})
public class UserController {
    /**
     * 用户Service.
     */
    @Autowired
    private UserService userService;

    /**
     * 分页获取所有用户信息.
     */
    @GetMapping("/{current}/{size}")
    @ApiOperation(value = "分页获取用户信息", notes = "分页获取用户信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getUsers(@PathVariable final Long current, @PathVariable final Long size){
        return ResponseData.success(userService.page(new Page<>(current, size)));
    }

    /**
     * 获取单个用户信息.
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个用户信息", notes = "获取单个用户信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getUser(@PathVariable final String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return ResponseData.success(userService.getOne(queryWrapper));
    }

    /**
     * 保存用户.
     */
    @PostMapping("/")
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息", httpMethod = "POST", response = ResponseData.class)
    public ResponseData saveUser(@RequestBody final User user){
        return userService.save(user) ? ResponseData.success("保存成功") : ResponseData.failure("保存失败");
    }

    /**
     * 更新用户.
     */
    @PutMapping("/")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息", httpMethod = "PUT", response = ResponseData.class)
    public ResponseData updateUser(@RequestBody final User user){
        return userService.updateById(user) ? ResponseData.success("更新成功") : ResponseData.failure("更新失败");
    }

    /**
     * 删除用户.
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息", httpMethod = "DELETE", response = ResponseData.class)
    public ResponseData deleteUser(@PathVariable final String id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return userService.remove(queryWrapper) ? ResponseData.success("删除成功") : ResponseData.failure("删除失败");
    }
}
