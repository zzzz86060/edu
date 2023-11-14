package com.zz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zz.entity.EduCourse;
import com.zz.entity.EduUser;
import com.zz.mapper.EduUserMapper;
import com.zz.service.IEduUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz
 * @since 2023-10-18
 */
@Service
public class EduUserServiceImpl extends ServiceImpl<EduUserMapper, EduUser> implements IEduUserService {
    @Resource
    private EduUserMapper eduUserMapper;
    public EduUser findByUserNameEduUser(String userName) {
        LambdaQueryWrapper<EduUser> eduUserQueryWrapper = new LambdaQueryWrapper<EduUser>();
        eduUserQueryWrapper.eq(EduUser::getUserName, userName);
        EduUser eduUser = eduUserMapper.selectOne(eduUserQueryWrapper);
        return eduUser;
    }

    @Override
    public EduUser getByUserId(Integer userId) {
        LambdaQueryWrapper<EduUser> eduUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        eduUserLambdaQueryWrapper.eq(EduUser::getUserId,userId);
        EduUser eduUser = eduUserMapper.selectOne(eduUserLambdaQueryWrapper);
        return eduUser;
    }

}
