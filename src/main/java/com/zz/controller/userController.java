package com.zz.controller;

import cn.hutool.core.bean.BeanUtil;
import com.zz.base.BaseApiController;
import com.zz.base.BaseResponse;
import com.zz.base.RedisUtils;
import com.zz.dtoresp.resp.EduUserRespDTO;
import com.zz.entity.EduUser;
import com.zz.service.IEduUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import javax.annotation.Resource;

/**
 * @author zz
 * @ClassName userController
 */
@RestController
@Slf4j
public class userController extends BaseApiController {
    @Resource
    private IEduUserService iEduUserService;
    @GetMapping("getByTokenUsrInfo")
    @ApiOperation(value = "用户token登录", notes = "用户token登录")
    public BaseResponse getByTokenUsrInfo(@RequestHeader String Token){
        if(StringUtils.isEmpty(Token)){
            log.error("token is null");
            return setResultError("token is null");
        }
        String redisvalue = RedisUtils.getString(Token);
        if(StringUtils.isEmpty(redisvalue)){
            return setResultError("token error");
        }
        Integer userId = Integer.valueOf(redisvalue);
        EduUser eduUser = iEduUserService.getByUserId(userId);
        EduUserRespDTO eduUserRespDTO = BeanUtil.toBean(eduUser, EduUserRespDTO.class);
        return setResultSuccessData(eduUserRespDTO);
    }
}
