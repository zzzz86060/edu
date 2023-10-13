package com.zz.service;

import com.zz.dtoresp.req.EduCourseReqDto;
import com.zz.dtoresp.resp.EduCourseRespDTO;
import com.zz.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author zz
 * @since 2023-10-13
 */
public interface IEduCourseService extends IService<EduCourse> {
    List<EduCourse> getAllEduCourse();
    /*
        基于内存查找数据
     */
    List<EduCourseRespDTO>searchcacheCourseList(EduCourseReqDto eduCourseReqDto);
}
