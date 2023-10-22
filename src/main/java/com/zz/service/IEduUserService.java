package com.zz.service;

import com.zz.entity.EduUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz
 * @since 2023-10-18
 */
public interface IEduUserService extends IService<EduUser> {
     EduUser findByUserNameEduUser(String userName);
    EduUser getByUserId(Integer userId);
}
