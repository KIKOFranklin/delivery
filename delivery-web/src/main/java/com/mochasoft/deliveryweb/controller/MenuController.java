package com.mochasoft.deliveryweb.controller;

import com.mochasoft.deliverydomain.Menu;
import com.mochasoft.deliveryservice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:31
 */
@RestController
@RequestMapping("/menu")
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Menu> getMenus(){
        return menuService.getMenu();
    }

    @RequestMapping(value = "/{flag}", method = RequestMethod.GET)
    public Menu getMenuItem(@PathVariable String flag) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createMenu(@RequestBody Menu menu) {
        return null;
    }

    @RequestMapping(value = "/{flag}", method = RequestMethod.PUT)
    public String edit(@PathVariable String flag) {
        return null;
    }

    @RequestMapping(value = "/{flag}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String flag) {
        return null;
    }

}
