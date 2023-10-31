package com.zz.service.impl;

import com.zz.entity.UserLoginLog;
import com.zz.mapper.UserLoginLogMapper;
import com.zz.service.IUserLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz
 * @since 2023-10-22
 */
@Service
@Slf4j
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements IUserLoginLogService {
    @Resource
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    @Transactional
    @Async("newSaskExecutor")
     public void addUserLoginLog(UserLoginLog userLoginLog) {
        try {
            Thread.sleep(3000);
            int insertResult = userLoginLogMapper.insert(userLoginLog);
            log.info("[插入数据：insertResult:{}]", insertResult);
        } catch (Exception e) {

        }
    }
}
