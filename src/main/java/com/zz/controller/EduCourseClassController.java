package com.zz.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zz.constant.Constants;
import com.zz.core.cache.LocalCache;
import com.zz.dtoresp.resp.EduCourseClassRespDTO;
import com.zz.service.IEduCourseClassService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zz.base.*;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz
 * @since 2023-10-11
 */
@Controller
@RequestMapping("/eduCourseClass")
@ApiOperation(value = "课程分类", notes = "课程分类")
@Slf4j
public class EduCourseClassController extends BaseApiController {
    @Resource
    private IEduCourseClassService iEduCourseClassService;

    @GetMapping("/getAllCourseClass")
    @ApiOperation(value = "查询所有课程分类", notes = "查询所有课程分类")
    @ResponseBody
    public BaseResponse getAllCourseClass() {
        List<EduCourseClassRespDTO> eduCourseClassRespList = new ArrayList<>();
        eduCourseClassRespList = LocalCache.get(Constants.COURSE_ALLCOURSECLASSLIST,
                eduCourseClassRespList);
        if (CollectionUtils.isEmpty(eduCourseClassRespList)) {
            log.error("[从集合中为查找到所有的课程分类数据]");
        }
        return setResultSuccessData(eduCourseClassRespList);
    }
}
