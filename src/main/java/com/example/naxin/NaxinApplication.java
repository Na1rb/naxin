package com.example.naxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.naxin.mapper")
public class NaxinApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaxinApplication.class, args);
        System.out.println("实验室报名系统启动成功！");
        System.out.println("访问地址: http://localhost:8080/students");
    }
}
