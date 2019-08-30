package com.tlf.creator;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, MultipartAutoConfiguration.class})
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
public class CreatorplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreatorplatformApplication.class, args);
    }


}
