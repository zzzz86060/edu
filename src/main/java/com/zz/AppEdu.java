package com.zz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zz
 * @ClassName AppEdu
 */
@SpringBootApplication
@MapperScan("com.zz.mapper")
@EnableAsync
public class AppEdu {
        public static void main(String[] args) {
            SpringApplication.run(AppEdu.class,args);
        }
}
