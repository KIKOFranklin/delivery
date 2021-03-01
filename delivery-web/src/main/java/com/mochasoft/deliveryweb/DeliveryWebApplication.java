package com.mochasoft.deliveryweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
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
