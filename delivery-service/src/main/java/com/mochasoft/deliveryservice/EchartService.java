package com.mochasoft.deliveryservice;

import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.vo.MoneyVO;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2021/8/15 3:34 下午
 */
public interface EchartService {
    ResponseData<List<MoneyVO>> generateSumEchartData();
    ResponseData<List<MoneyVO>> generateAttrEchartData(String param);
    ResponseData<List<MoneyVO>> generateWayEchartData(String param);
    ResponseData<List<MoneyVO>> generateIspayEchartData(String param);
}
