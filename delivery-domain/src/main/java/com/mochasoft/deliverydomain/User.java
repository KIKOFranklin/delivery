package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:31
 */
@Data
@TableName(value = "su_delivery_test")
public class User extends Model<User> {
    @TableId(value = "id")
    private String id;
    private String name;
    private String pwd;
}
