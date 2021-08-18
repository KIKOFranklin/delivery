package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mochasoft.deliverydomain.annotation.Between;
import com.mochasoft.deliverydomain.annotation.Likeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjiahao
 * @since 2021/8/8 3:49 下午
 */
@Data
@Builder
@TableName(value = "tb_money")
@NoArgsConstructor
@AllArgsConstructor
public class Money {
    /**
     * 主键ID.
     */
    @TableId(value = "ID")
    private int id;
    /**
     * 交易名称
     */
    @TableField("NAME")
    @Likeable
    private String name;
    /**
     * 交易金额
     */
    @TableField("AMOUNT")
    private String amount;
    /**
     * 交易日期
     */
    @TableField("DATE")
    private LocalDate date;
    /**
     * 交易属性
     */
    @TableField("ATTRIBUTE")
    private String attribute;
    /**
     * 交易途径
     */
    @TableField("WAY")
    private String way;
    /**
     * 支出/收入
     */
    @TableField("IS_PAY")
    private String isPay;
    /**
     * 查询起始时间
     */
    @Between("start")
    @TableField(exist = false, value = "DATE")
    private LocalDate startDate;
    /**
     * 查询结束时间
     */
    @Between("end")
    @TableField(exist = false, value = "DATE")
    private LocalDate endDate;
}
