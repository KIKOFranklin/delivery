package com.mochasoft.deliverydomain.vo;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjiahao
 * @since 2021/8/15 4:01 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoneyVO {
    private String date;
    private double amount;
    private String attrName;
}
