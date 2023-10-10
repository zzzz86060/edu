package com.zz.controller;


import com.zz.base.BaseApiController;
import com.zz.base.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController extends BaseApiController {

    /**
     * 测试状态码返回方式
     *
     * @return
     */
    @GetMapping("/test1")
    public BaseResponse test1() {
        return setResultSuccess();
    }
    @GetMapping("/test2")
    public BaseResponse test2() {
        int age;
        age = 0;
        int s = 4 / age;
            return setResultSuccess();

    }
    @GetMapping("/test04")
    @ApiOperation(value = "测试传递参数", notes = "测试传递参数")
    @ApiImplicitParam(paramType = "query", name = "name", value = "传递name", required = true)
    public BaseResponse test04(String name) {
        return setResultSuccess();
    }
}
