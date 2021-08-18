package com.mochasoft.deliveryservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mochasoft.deliverycore.exception.ServiceException;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverycore.utils.DateUtil;
import com.mochasoft.deliverydomain.Dictionary;
import com.mochasoft.deliverydomain.Money;
import com.mochasoft.deliverydomain.vo.MoneyVO;
import com.mochasoft.deliveryservice.DictionaryService;
import com.mochasoft.deliveryservice.EchartService;
import com.mochasoft.deliveryservice.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjiahao
 * @since 2021/8/15 3:35 下午
 */
@Service
public class EchartServiceImpl implements EchartService {

    @Autowired
    private MoneyService moneyService;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public ResponseData<List<MoneyVO>> generateSumEchartData() {
        try {
            List<LocalDate> dates = DateUtil.get15DaysByNow();
            List<MoneyVO> result = new ArrayList<>();
            dates.forEach(t -> {
                double sumAmount = 0;
                for (Money el : moneyService.list(new QueryWrapper<Money>().eq("DATE", t).eq("IS_PAY", 0))
                ) {
                    sumAmount += Double.parseDouble(el.getAmount());
                }
                result.add(
                        MoneyVO.builder().date(t.toString()).amount(sumAmount).build()
                );
            });
            return ResponseData.success(result);
        } catch (Exception e) {
            throw new ServiceException("日金额汇总数据生产异常");
        }
    }

    @Override
    public ResponseData<List<MoneyVO>> generateAttrEchartData(final String param) {
        List<MoneyVO> result = new ArrayList<>();
        int length = param.length();
        switch (length) {
            case 4:
                return echartDataGenerator(result, dbResultGenerator(0, param), param, 7, "MONEY_ATTR", 0);
            case 7:
                return echartDataGenerator(result, dbResultGenerator(1, param), param, 7, "MONEY_ATTR", 0);
            default: {
                throw new ServiceException("月份或年份参数异常");
            }
        }
    }

    @Override
    public ResponseData<List<MoneyVO>> generateWayEchartData(final String param) {
        List<MoneyVO> result = new ArrayList<>();
        int length = param.length();
        switch (length) {
            case 4:
                return echartDataGenerator(result, dbResultGenerator(0, param), param, 3, "MONEY_WAY", 1);
            case 7:
                return echartDataGenerator(result, dbResultGenerator(1, param), param, 3, "MONEY_WAY", 1);
            default: {
                throw new ServiceException("月份或年份参数异常");
            }
        }
    }

    @Override
    public ResponseData<List<MoneyVO>> generateIspayEchartData(final String param) {
        List<MoneyVO> result = new ArrayList<>();
        int length = param.length();
        switch (length) {
            case 4:
                return echartDataGenerator(result, dbResultGenerator(0, param), param, 1, "MONEY_ISPAY", 2);
            case 7:
                return echartDataGenerator(result, dbResultGenerator(1, param), param, 1, "MONEY_ISPAY", 2);
            default: {
                throw new ServiceException("月份或年份参数异常");
            }
        }
    }

    /**
     * echart数据生产器
     * @param result 结果集
     * @param yearResultInDb 时间段内的所有数据
     * @param param 日期或年份
     * @param loopIndex 循环次数
     * @param dicName 字典中的属性名字=
     * @param divider 业务区分 0交易性质 1交易途径 2支出/收入
     * @return 响应数据
     */
    private ResponseData<List<MoneyVO>> echartDataGenerator(final List<MoneyVO> result,
                                                                        final List<Money> yearResultInDb,
                                                                        final String param,
                                                                        final int loopIndex,
                                                                        final String dicName,
                                                                        final int divider){
        for (int i = 0; i <= loopIndex; ++i) {
            double yearSummary = 0;
            int index = -1;
            for (Money el : yearResultInDb) {
                switch (divider){
                    case 0:
                        if (i == Integer.parseInt(el.getAttribute())) {
                            yearSummary += Double.parseDouble(el.getAmount());
                            index = i;
                        }
                        break;
                    case 1:
                        if (i == Integer.parseInt(el.getWay())) {
                            yearSummary += Double.parseDouble(el.getAmount());
                            index = i;
                        }
                        break;
                    case 2:
                        if (i == Integer.parseInt(el.getIsPay())) {
                            yearSummary += Double.parseDouble(el.getAmount());
                            index = i;
                        }
                        break;
                    default: {
                        throw new ServiceException("业务区分符参数有误");
                    }
                }
            }
            String attrName = null;
            if(index != -1){
                attrName = dictionaryService.getOne(new QueryWrapper<Dictionary>().eq("DIC_NAME", dicName).eq("DIC_ID", index)).getDicValue();
            }
            result.add(MoneyVO.builder().date(param).amount(yearSummary).attrName(attrName).build());
        }
        return ResponseData.success(result);
    }

    /**
     * 相应时间段内数据生产器
     * @param divider 业务区分 0年 1月
     * @param param 日期或年份
     * @return 时间段内的所有数据
     */
    private List<Money> dbResultGenerator(final int divider, final String param){
        switch (divider){
            case 0:
                LocalDate startDate = DateUtil.getYearBegin(LocalDate.of(Integer.parseInt(param), 1, 1));
                LocalDate endDate = DateUtil.getYearEnd(LocalDate.of(Integer.parseInt(param), 1, 1));
                return moneyService.list(new QueryWrapper<Money>().ge("DATE", startDate).le("DATE", endDate));
            case 1:
                startDate = DateUtil.getMonthBegin(LocalDate.of(Integer.parseInt(param.substring(0, 4)), Integer.parseInt(param.substring(5, 7)), 1));
                endDate = DateUtil.getMonthEnd(LocalDate.of(Integer.parseInt(param.substring(0, 4)), Integer.parseInt(param.substring(5, 7)), 1));
                return moneyService.list(new QueryWrapper<Money>().ge("DATE", startDate).le("DATE", endDate));
            default:{
                throw new ServiceException("业务区分参数有误");
            }
        }
    }
}
