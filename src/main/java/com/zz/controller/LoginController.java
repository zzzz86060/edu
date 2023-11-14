package com.zz.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;
import com.zz.base.*;
import com.zz.dtoresp.req.LoginReqDto;
import com.zz.entity.EduUser;
import com.zz.entity.UserLoginLog;
import com.zz.service.IEduUserService;
import com.zz.service.IUserLoginLogService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * @author zz
 * @ClassName LoginController
 *
 */
@RestController
@Slf4j
@ApiOperation(value = "登录", notes = "登录信息")
public class LoginController extends BaseApiController {
    @Resource
    private IUserLoginLogService    userLoginLogService;
    @Resource
    private IEduUserService eduUserService;



    @ApiOperation(value = "登录", notes = "登录信息")
    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginReqDto loginReqDto
    , HttpServletRequest request) {
        String userName = loginReqDto.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null]");
            return setResultError("userName is null");
        }
        String imgCaptcha = loginReqDto.getImgCaptcha();
        if (StringUtils.isEmpty(imgCaptcha)) {
            log.error("[imgCaptcha is null]");
            return setResultError("[imgCaptcha is null]");
        }
        if (!CaptchaUtil.ver(imgCaptcha, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return setResultError("[imgCaptcha is error]");
        }
        // 查询用户信息
        EduUser dbEduUser = eduUserService.findByUserNameEduUser(userName);
        if (dbEduUser == null) {
            log.error("[未查找到用户信息]");
            return setResultError("账户或者密码错误");
        }
        String userSalt = dbEduUser.getUserSalt();
        String newPwd = MD5Utils.md5(loginReqDto.getPassword() + userSalt);
        // 比对数据库密码
        if (!newPwd.equals(dbEduUser.getPassword())) {
            return setResultError("账户或者密码错误");
        }
        String userToken = TokenUtils.getToken();
        Integer userId = dbEduUser.getUserId();
        RedisUtils.setString(userToken, userId);
        HashMap<String, String> result = new HashMap<>();
        result.put("userToken", userToken);
        log.info("[登录成功]" + userToken);
        UserLoginLog userLoginLog = new UserLoginLog(userId,
                RquestUtils.getIpAddr(), new Date(), userToken
                , RquestUtils.getEquipment());
        log.info("登录日志" + userLoginLog);
        userLoginLogService.addUserLoginLog(userLoginLog);
        log.info("结束");
        return setResultSuccessData(result);
    }
}
