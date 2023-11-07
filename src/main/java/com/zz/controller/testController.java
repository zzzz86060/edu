package com.zz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zz
 * @ClassName testController
 */
@RestController
public class testController {
    @GetMapping("test")
    public String test(){
        return "test";
    }
}
