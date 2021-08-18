package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjiahao
 * @since 2021/8/8 12:33 下午
 */
@Data
@Builder
@TableName(value = "tb_dictionary")
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary extends Model<Dictionary> {
    /**
     * 主键ID.
     */
    @TableId(value = "ID")
    private int id;
    /**
     * 字典id
     */
    @TableField("DIC_ID")
    private String dicId;
    /**
     * 字典value
     */
    @TableField("DIC_VALUE")
    private String dicValue;
    /**
     * 是否激活
     */
    @TableField("IS_ACTIVE")
    private String isActive;
    /**
     * 排序编号
     */
    @TableField("DIC_ORDER")
    private int dicOrder;
}
