package com.zz.service;

import com.zz.entity.EduCourseClass;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz
 * @since 2023-10-11
 */
public interface IEduCourseClassService extends IService<EduCourseClass> {
    List<EduCourseClass> getAllCourseClass();
}
