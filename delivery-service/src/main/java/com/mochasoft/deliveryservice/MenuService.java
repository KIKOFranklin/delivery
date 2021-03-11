package com.mochasoft.deliveryservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mochasoft.deliverydomain.Menu;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:18
 */
public interface MenuService extends IService<Menu> {
    /**
     * 获取菜单集合.
     * @return List<Menu>
     */
    List<Menu> getMenu();
}
