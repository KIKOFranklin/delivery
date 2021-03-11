package com.mochasoft.deliverydomain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 15:42
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "su_delivery_menu_tree")
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;
    /**
     * 菜单ID.
     */
    @TableId(value = "MENU_ID")
    private String menuId;
    /**
     * 菜单名称.
     */
    @TableField(value = "MENU_NAME")
    private String menuName;
    /**
     * 父级菜单ID.
     */
    @TableField(value = "SUPER_MENU_ID")
    private String superMenuId;
    /**
     * 菜单URL.
     */
    @TableField(value = "MENU_URL")
    private String menuUrl;
    /**
     * 菜单排序.
     */
    @TableField(value = "MENU_ORDER")
    private Integer menuOrder;
    /**
     * 是否打开新窗口.
     */
    @TableField(value = "IS_OPEN_WIN")
    private String isOpenWin;
    /**
     * 是否是外部链接.
     */
    @TableField(value = "IS_EXT_LINK")
    private String isExtLink;
    /**
     * 是否是父级菜单.
     */
    @TableField(value = "IS_PARENT")
    private String isParent;
    /**
     * 子菜单集合.
     */
    @TableField(exist = false)
    private Collection<Menu> childrenMenu;
}
