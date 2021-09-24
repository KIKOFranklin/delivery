package com.mochasoft.deliveryweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.Dictionary;
import com.mochasoft.deliverydomain.User;
import com.mochasoft.deliverysecurity.jwt.JwtToken;
import com.mochasoft.deliveryservice.DictionaryService;
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
@RequestMapping("/dic")
@Api(value = "字典信息接口", tags = {"DictionaryController接口"})
public class DictionaryController {
    /**
     * 用户Service.
     */
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 分页获取所有用户信息.
     */
    @GetMapping("/{current}/{size}")
    @JwtToken
    @ApiOperation(value = "分页获取字典信息", notes = "分页获取字典信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getDics(@PathVariable final Long current, @PathVariable final Long size){
        return ResponseData.success(dictionaryService.page(new Page<>(current, size)));
    }

    /**
     * 获取单个字典信息.
     */
    @GetMapping("/getDic/{id}")
    @JwtToken
    @ApiOperation(value = "获取单个字典信息", notes = "获取单个字典信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getDic(@PathVariable final String id){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return ResponseData.success(dictionaryService.getOne(queryWrapper));
    }

    /**
     * 根据字典名获取所有字典信息.
     */
    @GetMapping("/getDics/{dicName}")
    @JwtToken
    @ApiOperation(value = "获取单个字典信息", notes = "获取单个字典信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getDicByDicName(@PathVariable final String dicName){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DIC_NAME", dicName);
        return ResponseData.success(dictionaryService.list(queryWrapper));
    }

    /**
     * 保存用户.
     */
    @PostMapping("/")
    @JwtToken
    @ApiOperation(value = "保存字典信息", notes = "保存字典信息", httpMethod = "POST", response = ResponseData.class)
    public ResponseData saveUser(@RequestBody final Dictionary dictionary){
        return dictionaryService.save(dictionary) ? ResponseData.success("保存成功") : ResponseData.failure("保存失败");
    }

    /**
     * 更新用户.
     */
    @PutMapping("/")
    @JwtToken
    @ApiOperation(value = "更新字典信息", notes = "更新字典信息", httpMethod = "PUT", response = ResponseData.class)
    public ResponseData updateUser(@RequestBody final Dictionary dictionary){
        return dictionaryService.updateById(dictionary) ? ResponseData.success("更新成功") : ResponseData.failure("更新失败");
    }

    /**
     * 删除用户.
     */
    @DeleteMapping("/{id}")
    @JwtToken
    @ApiOperation(value = "删除字典信息", notes = "删除字典信息", httpMethod = "DELETE", response = ResponseData.class)
    public ResponseData deleteUser(@PathVariable final String id){
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return dictionaryService.remove(queryWrapper) ? ResponseData.success("删除成功") : ResponseData.failure("删除失败");
    }
}
