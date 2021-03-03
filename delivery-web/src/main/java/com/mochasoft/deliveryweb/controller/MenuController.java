package com.mochasoft.deliveryweb.controller;

import com.mochasoft.deliverydomain.Menu;
import com.mochasoft.deliveryservice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:31
 */
@RestController
public class MenuController {
    /**
     * 菜单Service.
     */
    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单.
     * @return 菜单List.
     */
    @GetMapping("/getMenu")
    public List<Menu> getMenus(){
        return menuService.getMenu();
    }
}
