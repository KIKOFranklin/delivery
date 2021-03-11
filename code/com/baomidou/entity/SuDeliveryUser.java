package com.baomidou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author KIKOFranklin
 * @since 2021-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SU_DELIVERY_USER")
public class SuDeliveryUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 唯一标识
     */
    @TableId("ID")
    private String id;

    /**
     * 卡号
     */
    @TableField("CARD_ID")
    private String cardId;

    /**
     * 员工姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 员工手机号
     */
    @TableField("USER_MOBILE")
    private String userMobile;

    /**
     * 员工编号
     */
    @TableField("USER_IDENTIFIER")
    private String userIdentifier;

    /**
     * 公司
     */
    @TableField("USER_COMPANY")
    private String userCompany;

    /**
     * 部门
     */
    @TableField("USER_DEPT")
    private String userDept;

    /**
     * 所属二级食堂
     */
    @TableField("USER_CANTEEN")
    private String userCanteen;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("LAST_MODIFIED_TIME")
    private LocalDateTime lastModifiedTime;


}
