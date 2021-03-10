package com.mochasoft.deliveryservice;

import com.mochasoft.deliverydomain.Menu;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:18
 */
public interface MenuService {
    /**
     * 获取菜单集合.
     * @return List<Menu>
     */
    List<Menu> getMenu();
}
