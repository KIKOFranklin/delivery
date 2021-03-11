package com.mochasoft.deliveryweb.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KIKOFranklin
 * @create 2021/3/11 0011 9:33
 */
public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("./code");  //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setAuthor("KIKOFranklin"); //设置作者
        gc.setOpen(false);
        gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setBaseResultMap(true); //生成resultMap
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@172.23.22.101:1521:orcl");
        dsc.setDriverName("oracle.jdbc.OracleDriver");
        dsc.setUsername("jssupport");
        dsc.setPassword("password");
        mpg.setDataSource(dsc);

        // 3、包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("sys");
//        pc.setParent("com.lcy.demo");
//        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperControllerClass("com.lcy.demo.sys.controller.BaseController");
//        strategy.setSuperEntityClass("com.lcy.demo.sys.entity.BaseEntity");
        // strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setEntityLombokModel(true); //使用lombok
        strategy.setInclude("su_delivery_user");  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
        mpg.setStrategy(strategy);

        //5、执行
        mpg.execute();

    }
}
