package com.zz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.entity.EduCourseClass;
import com.zz.mapper.EduCourseClassMapper;
import com.zz.service.IEduCourseClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz
 * @since 2023-10-11
 */
@Service
public class EduCourseClassServiceImpl extends ServiceImpl<EduCourseClassMapper, EduCourseClass> implements IEduCourseClassService {
    @Resource
    private EduCourseClassMapper eduCourseClassMapper;
    @Override
    public List<EduCourseClass> getAllCourseClass() {
        QueryWrapper<EduCourseClass> objectQueryWrapper = new QueryWrapper<>();
        return eduCourseClassMapper.selectList(objectQueryWrapper);
    }
}
