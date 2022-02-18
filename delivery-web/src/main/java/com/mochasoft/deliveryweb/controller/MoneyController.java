package com.mochasoft.deliveryweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverycore.utils.ReflectUtil;
import com.mochasoft.deliverydomain.Dictionary;
import com.mochasoft.deliverydomain.Money;
import com.mochasoft.deliverysecurity.jwt.JwtToken;
import com.mochasoft.deliveryservice.DictionaryService;
import com.mochasoft.deliveryservice.MoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


/**
 * @author KIKOFranklin
 */
@RestController
@RequestMapping("/tran")
@Api(value = "交易信息接口", tags = {"MoneyController接口"})
public class MoneyController {
    /**
     * 用户Service.
     */
    @Autowired
    private MoneyService moneyService;

    /**
     * 字典Service.
     */
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 分页获取所有交易信息.
     */
    @GetMapping("/{current}/{size}")
    @JwtToken
    @ApiOperation(value = "分页获取交易信息", notes = "分页获取交易信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getDics(@PathVariable final Long current, @PathVariable final Long size){
        IPage<Money> result = moneyService.page(
                new Page<>(current, size),
                new QueryWrapper<Money>().orderBy(true,false,"DATE")
        );
        result.getRecords().forEach(t -> {
                    t.setAttributeName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getAttribute()).eq("DIC_NAME", "MONEY_ATTR")).getDicValue());
                    t.setWayName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getWay()).eq("DIC_NAME", "MONEY_WAY")).getDicValue());
                    t.setIsPayName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getIsPay()).eq("DIC_NAME", "MONEY_ISPAY")).getDicValue());
        });
        return ResponseData.success(
                result.setRecords(result.getRecords())
        );
    }

    /**
     * 获取单个字典信息.
     */
    @GetMapping("/{id}")
    @JwtToken
    @ApiOperation(value = "获取单个交易信息", notes = "获取单个交易信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getDic(@PathVariable final String id){
        QueryWrapper<Money> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return ResponseData.success(moneyService.getOne(queryWrapper));
    }

    /**
     * 根据条件获取交易信息.
     */
    @PostMapping ("/query/{current}/{size}")
    @JwtToken
    @ApiOperation(value = "根据条件获取交易信息", notes = "根据条件获取交易信息", httpMethod = "POST", response = ResponseData.class)
    public ResponseData getMoneyByParam(@RequestBody final Money money,
                                        @PathVariable final Long current,
                                        @PathVariable final Long size){
        if(money.getStartDate() != null){
            money.setStartDate(money.getStartDate().plusDays(1));
        }
        if(money.getEndDate() != null){
            money.setEndDate(money.getEndDate().plusDays(1));
        }
        IPage<Money> result = moneyService.page(
                new Page<>(current, size),
                ReflectUtil.generateWrapperByReflection(money)
        );
        result.getRecords().forEach(t -> {
            t.setAttributeName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getAttribute()).eq("DIC_NAME", "MONEY_ATTR")).getDicValue());
            t.setWayName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getWay()).eq("DIC_NAME", "MONEY_WAY")).getDicValue());
            t.setIsPayName(dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_ID", t.getIsPay()).eq("DIC_NAME", "MONEY_ISPAY")).getDicValue());
        });
        return ResponseData.success(
                result.setRecords(result.getRecords())
        );
    }
    
    /**
     * 保存用户.
     */
    @PostMapping("/")
    @JwtToken
    @ApiOperation(value = "保存交易信息", notes = "保存交易信息", httpMethod = "POST", response = ResponseData.class)
    public ResponseData saveUser(@RequestBody final Money money){
        money.setDate(money.getDate().plusDays(1));
        return moneyService.save(money) ? ResponseData.success("保存成功") : ResponseData.failure("保存失败");
    }

    /**
     * 更新用户.
     */
    @PutMapping("/")
    @JwtToken
    @ApiOperation(value = "更新交易信息", notes = "更新交易信息", httpMethod = "PUT", response = ResponseData.class)
    public ResponseData updateUser(@RequestBody final Money money){
        money.setDate(money.getDate().plusDays(1));
        return moneyService.updateById(money) ? ResponseData.success("更新成功") : ResponseData.failure("更新失败");
    }

    /**
     * 删除用户.
     */
    @DeleteMapping("/{id}")
    @JwtToken
    @ApiOperation(value = "删除交易信息", notes = "删除交易信息", httpMethod = "DELETE", response = ResponseData.class)
    public ResponseData deleteUser(@PathVariable final String id){
        QueryWrapper<Money> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID", id);
        return moneyService.remove(queryWrapper) ? ResponseData.success("删除成功") : ResponseData.failure("删除失败");
    }
}
