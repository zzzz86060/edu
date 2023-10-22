package com.zz.service;

import com.zz.entity.UserLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz
 * @since 2023-10-22
 */
public interface IUserLoginLogService extends IService<UserLoginLog> {
    void addUserLoginLog(UserLoginLog userLoginLog);
}
