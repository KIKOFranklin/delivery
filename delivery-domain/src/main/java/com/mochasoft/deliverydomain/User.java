package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:31
 */
@Data
@Builder
@TableName(value = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {
    /**
     * 主键ID.
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;
    /**
     * 员工姓名.
     */
    @TableField(value = "USER_NAME")
    private String userName;
    /**
     * 员工手机号.
     */
    @TableField(value = "USER_MOBILE")
    private String userMobile;
    /**
     * 密码
     */
    @TableField("USER_PWD")
    private String userPwd;
    /**
     * 邮箱
     */
    @TableField("USER_EMAIL")
    private String userEmail;

    /**
     * 创建时间.
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT, jdbcType = JdbcType.TIMESTAMP)
    private LocalDate createTime;

    /**
     * 最后修改时间.
     */
    @TableField(value = "LAST_MODIFIED_TIME", fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.TIMESTAMP)
    private LocalDate lastModifiedTime;
}
