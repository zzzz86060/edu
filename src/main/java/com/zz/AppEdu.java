package com.zz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zz
 * @ClassName AppEdu
 */
@SpringBootApplication
@MapperScan("com.zz.mapper")
public class AppEdu {
    public static void main(String[] args) {
        SpringApplication.run(AppEdu.class,args);
    }
}
