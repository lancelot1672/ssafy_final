package com.ssafy.home.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.home.*.repository")
public class MyBatisConfig {

}
