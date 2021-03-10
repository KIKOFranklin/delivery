package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author KIKOFranklin
 * @create 2021/3/1 0001 15:31
 */
@Data
@Builder
@TableName(value = "su_delivery_user")
public class User extends Model<User> {
    /**
     * 主键ID.
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;
    /**
     * 卡号.
     */
    @TableField(value = "CARD_ID")
    private String cardId;
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
     * 员工编号.
     */
    @TableField(value = "USER_IDENTIFIER")
    private String userIdentifier;
    /**
     * 员工所属公司.
     */
    @TableField(value = "USER_COMPANY")
    private String userCompany;
    /**
     * 员工所属部门.
     */
    @TableField(value = "USER_DEPT")
    private String userDept;
    /**
     * 所属二级食堂.
     */
    @TableField(value = "USER_CANTEEN")
    private String userCanteen;
    /**
     * 创建时间.
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 最后修改时间.
     */
    @TableField(value = "LAST_MODIFIED_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastModifiedTime;
}
