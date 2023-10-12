package com.zz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zz.constant.Constants;
import com.zz.core.cache.LocalCache;
import com.zz.dtoresp.EduCourseClassRespDTO;
import com.zz.entity.EduCourseClass;
import com.zz.service.IEduCourseClassService;
import com.zz.service.IStartPreheatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zz
 * @ClassName IStartPreheatServiceImpI
 */
@Service
@Slf4j
public class IStartPreheatServiceImpI implements IStartPreheatService {
    @Resource
    private IEduCourseClassService iEduCourseClassService;
    @Override
    public void initData() {
        /*
            初始化课程分类
         */
        Long startTime = System.currentTimeMillis();
        initCourse();
        Long endTime = System.currentTimeMillis();
        log.info("初始化课程分类耗时：{}",endTime-startTime);
    }
    public void initCourse(){
        List<EduCourseClass> allCourseClassList = iEduCourseClassService.getAllCourseClass();
        List<EduCourseClassRespDTO> alleduCourseClassRespDTOS = BeanUtil.copyToList(allCourseClassList,EduCourseClassRespDTO.class);
        LocalCache.put(Constants.COURSE_ALLCOURSECLASSLIST,alleduCourseClassRespDTOS);
    }
}
