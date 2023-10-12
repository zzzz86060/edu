package com.zz.init;


import com.zz.service.IStartPreheatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/*
启动后初始化类
 */
@Component
@Slf4j
public class StartPreheatApplicationRunner implements ApplicationRunner {
    @Resource
    private IStartPreheatService iStartPreheatService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        iStartPreheatService.initData();
    }
}