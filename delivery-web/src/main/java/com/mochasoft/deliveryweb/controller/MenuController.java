package com.mochasoft.deliveryweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mochasoft.deliverycore.response.ResponseData;
import com.mochasoft.deliverydomain.Menu;
import com.mochasoft.deliveryservice.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author KIKOFranklin
 * @create 2021/3/3 0003 16:31
 */
@RestController
@RequestMapping("/menu")
@Api(value = "菜单信息接口", tags = {"MenuController接口"})
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
    @GetMapping("/")
    @ApiOperation(value = "获取所有菜单信息", notes = "获取所有菜单信息", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getMenus(){
        return ResponseData.success(menuService.getMenu());
    }

    /**
     * 获取特定菜单.
     * @param flag 参数
     * @return 菜单实体
     */
    @GetMapping("/{flag}")
    @ApiOperation(value = "获取单个菜单信息", notes = "路径参数flag为传入的menuId", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getMenuItem(@PathVariable final String flag) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MENU_ID", flag);
        return ResponseData.success(menuService.getOne(queryWrapper));
    }

    @GetMapping("/{current}/{size}")
    @ApiOperation(value = "分页查询菜单信息", notes = "current当前页 size当前页数据长度", httpMethod = "GET", response = ResponseData.class)
    public ResponseData getMenusByPage(@PathVariable final Long current, @PathVariable final Long size){
        return ResponseData.success(menuService.page(new Page<>(current, size)));
    }

    /**
     * 创建菜单.
     * @return 系统提示.
     */
    @PostMapping("/")
    @ApiOperation(value = "保存菜单信息", notes = "menuId不能为空", httpMethod = "POST", response = ResponseData.class)
    public ResponseData createMenu(@RequestBody final Menu menu) {
        return menuService.save(menu) ? ResponseData.success("保存成功") : ResponseData.failure("保存失败");
    }

    /**
     * 编辑菜单.
     * @return 系统提示
     */
    @PutMapping("/")
    @ApiOperation(value = "编辑菜单信息", notes = "menuId不能为空", httpMethod = "PUT", response = ResponseData.class)
    public ResponseData edit(@RequestBody final Menu menu) {
        return menuService.updateById(menu) ? ResponseData.success("修改成功") : ResponseData.failure("修改失败");
    }
    /**
     * 删除菜单.
     * @param flag 参数
     * @return 系统提示
     */
    @DeleteMapping("/{flag}")
    @ApiOperation(value = "删除菜单信息", notes = "menuId不能为空", httpMethod = "DELETE", response = ResponseData.class)
    public ResponseData delete(@PathVariable final String flag) {
        QueryWrapper<Menu> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("MENU_ID", flag);
        return menuService.remove(queryWrapper) ?
                ResponseData.success("删除成功") : ResponseData.failure("删除失败");
    }

}
