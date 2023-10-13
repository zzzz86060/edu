package com.zz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zz.constant.Constants;
import com.zz.core.cache.LocalCache;
import com.zz.dtoresp.req.EduCourseReqDto;
import com.zz.dtoresp.resp.EduCourseRespDTO;
import com.zz.entity.EduCourse;
import com.zz.entity.EduCourseClass;
import com.zz.mapper.EduCourseMapper;
import com.zz.service.IEduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author zz
 * @since 2023-10-13
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements IEduCourseService {
    @Resource
    private EduCourseMapper eduCourseMapper;
    @Override
    public List<EduCourse> getAllEduCourse() {
        QueryWrapper<EduCourse> objectQueryWrapper = new QueryWrapper<>();
        return eduCourseMapper.selectList(objectQueryWrapper);
    }

    @Override
    public List<EduCourseRespDTO> searchcacheCourseList(EduCourseReqDto eduCourseReqDto) {
        //查询缓存中的数据并放在eduCourseRespList
        List<EduCourseRespDTO> eduCourseRespList = new ArrayList<>();
        eduCourseRespList = LocalCache.get(
                Constants.COURSE_EDUCOURSERESPLIST, eduCourseRespList);
        if (CollectionUtils.isEmpty(eduCourseRespList)) {
            log.error("[从缓存中为查找到eduCourseRespList数据]");
            return null;
        }

        //  模糊查询
        Stream<EduCourseRespDTO> stream = eduCourseRespList.stream();

        String courseName = eduCourseReqDto.getCourseName();

        if (!StringUtils.isEmpty(courseName)) {
            stream = stream.filter(c ->
                    StrUtil.containsIgnoreCase(c.getCourseName(), (courseName)));
        }


        /*
        学科分类
         */
        Integer subjectId = eduCourseReqDto.getSubjectId();
        if (subjectId != null) {
            stream = stream.filter((c) -> c.getSubjectId().equals(subjectId));
        }

        /*
            基于时间排序
         */
        return stream.sorted(Comparator.comparing(EduCourseRespDTO::getAddTime)).collect(Collectors.toList());
    }
}
