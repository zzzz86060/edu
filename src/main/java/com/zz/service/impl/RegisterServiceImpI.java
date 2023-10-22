package com.zz.service.impl;

import com.zz.base.MD5Utils;
import com.zz.base.SaltUtils;
import com.zz.constant.Constants;
import com.zz.dtoresp.req.EduUserReqDTO;
import com.zz.entity.EduUser;
import com.zz.mapper.EduUserMapper;
import com.zz.service.IEduUserService;
import com.zz.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author zz
 * @ClassName RegisterServiceImpI
 */
@Service
@Slf4j
public class RegisterServiceImpI implements RegisterService {
    @Resource
    private IEduUserService iEduUserService;
    @Resource
    private EduUserMapper eduUserMapper;


    @Override
    public boolean register(EduUserReqDTO eduUserReqDTO) {
        String userName = eduUserReqDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null");
            return Boolean.FALSE;
        }
        String passWord = eduUserReqDTO.getPassword();
        if (StringUtils.isEmpty(userName)) {
            log.error("[passWord is null");
            return Boolean.FALSE;
        }
        EduUser dbEduUser
                = iEduUserService.findByUserNameEduUser(userName);
        if (dbEduUser != null) {
            log.error("[用户已经存在]", dbEduUser);
            return false;
        }
        String salt = SaltUtils.getSalt();
        String newPwd = MD5Utils.md5(passWord + salt);
        dbEduUser = new EduUser();
        dbEduUser.setUserSalt(salt);
        dbEduUser.setPassword(newPwd);
        dbEduUser.setUserName(userName);
        return eduUserMapper.insert(dbEduUser) > Constants.DB_INSERT_RESULT_BIGZERO;
    }

}

