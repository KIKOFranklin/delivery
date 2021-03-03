package com.mochasoft.deliveryservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mochasoft.deliverydao.mapper.MenuMapper;
import com.mochasoft.deliverydomain.Menu;
import com.mochasoft.deliveryservice.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:21
 */
@Service
public class MenuServiceImpl implements MenuService {
    /**
     * 菜单Mapper.
     */
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenu() {
        List<Menu> menuList =  menuMapper.selectList(new QueryWrapper<>());
        List<Menu> result = new ArrayList<>();
        //包装父子级菜单
        for (Menu menu: menuList) {
            if (isBlank(menu.getSuperMenuId())) {
                setChildrenMenu(menu, menuList);
                result.add(menu);
            }
        }
        return result;
    }

    private void setChildrenMenu(Menu menu, Collection<Menu> menus) {
        Collection<Menu> children = new ArrayList<>();
        for (Menu child: menus) {
            if (StringUtils.equals(child.getSuperMenuId(), menu.getMenuId())) {
                setChildrenMenu(child, menus);
                children.add(child);
            }
        }
        menu.setChildrenMenu(children);
    }
}
