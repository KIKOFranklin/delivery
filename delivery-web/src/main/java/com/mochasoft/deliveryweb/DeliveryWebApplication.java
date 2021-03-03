package com.mochasoft.deliveryweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@MapperScan(basePackages = "com.mochasoft.deliverydao.mapper")
@ComponentScan({
        "com.mochasoft.deliveryservice",
        "com.mochasoft.deliveryweb",
        "com.mochasoft.deliverycore",
        "com.mochasoft.deliverydao",
        "com.mochasoft.deliverydomain"})
public class DeliveryWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryWebApplication.class, args);
    }

}
