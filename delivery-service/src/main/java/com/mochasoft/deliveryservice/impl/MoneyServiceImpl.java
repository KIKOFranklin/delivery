package com.mochasoft.deliveryservice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mochasoft.deliverydao.mapper.DictionaryMapper;
import com.mochasoft.deliverydao.mapper.MoneyMapper;
import com.mochasoft.deliverydomain.Dictionary;
import com.mochasoft.deliverydomain.Money;
import com.mochasoft.deliveryservice.DictionaryService;
import com.mochasoft.deliveryservice.MoneyService;
import org.springframework.stereotype.Service;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:38
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money> implements MoneyService {

}
