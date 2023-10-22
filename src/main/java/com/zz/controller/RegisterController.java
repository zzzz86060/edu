package com.zz.controller;

import com.zz.base.BaseApiController;
import com.zz.base.BaseResponse;
import com.zz.dtoresp.req.EduUserReqDTO;
import com.zz.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author zz
 * @ClassName RegisterController
 */
@RestController
@Slf4j
public class RegisterController extends BaseApiController {
    @Resource
    private RegisterService registerService;

    @PostMapping("register")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public BaseResponse register(@RequestBody EduUserReqDTO
                                         eduUserReqDTO) {

        String userName = eduUserReqDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null");
            return setResultError("userName is null");
        }
        String passWord = eduUserReqDTO.getPassword();
        if (StringUtils.isEmpty(userName)) {
            log.error("[passWord is null");
            return setResultError("passWord is null");
        }
        //注册
       return registerService.register(eduUserReqDTO)?setResultSuccess():setResultError();
    }

}

