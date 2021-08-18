package com.mochasoft.deliveryweb.controller;

import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.vo.MoneyVO;
import com.mochasoft.deliveryservice.EchartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author wangjiahao
 * @since 2021/8/15 3:27 下午
 */
@RestController
@RequestMapping("/echart")
@Api(value = "图表信息接口", tags = {"EchartController接口"})
public class EchartController {

    @Autowired
    private EchartService echartService;

    @RequestMapping("/sum")
    @ApiOperation(value = "获取每日金额汇总图表信息", notes = "获取每日金额汇总图表信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData<List<MoneyVO>> getSumEchartData(){
        return echartService.generateSumEchartData();
    }

    @RequestMapping("/attr/{param}")
    @ApiOperation(value = "获取交易属性图表信息", notes = "获取交易属性图表信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData<List<MoneyVO>> getAttrEchartData(@PathVariable final String param){
        return echartService.generateAttrEchartData(param);
    }

    @RequestMapping("/way/{param}")
    @ApiOperation(value = "获取交易途径图表信息", notes = "获取交易途径图表信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData<List<MoneyVO>> getWayEchartData(@PathVariable final String param){
        return echartService.generateWayEchartData(param);
    }

    @RequestMapping("/ispay/{param}")
    @ApiOperation(value = "获取支出/收入图表信息", notes = "获取支出/收入图表信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData<List<MoneyVO>> getIsPayEchartData(@PathVariable final String param){
        return echartService.generateIspayEchartData(param);
    }
}
