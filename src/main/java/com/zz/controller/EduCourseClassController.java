package com.zz.controller;


import com.zz.constant.Constants;
import com.zz.core.cache.LocalCache;
import com.zz.entity.EduCourseClass;
import com.zz.service.IEduCourseClassService;
import io.swagger.annotations.ApiOperation;
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
public class EduCourseClassController extends BaseApiController {
    @Resource
    private IEduCourseClassService iEduCourseClassService;

    @GetMapping("/getAllCourseClass")
    @ApiOperation(value = "查询所有课程分类", notes = "查询所有课程分类")
    @ResponseBody
    public BaseResponse getAllCourseClass() {
        List<EduCourseClass> allCourseClass = new ArrayList<>();
      allCourseClass = LocalCache.get(Constants.COURSE_ALLCOURSECLASSLIST,allCourseClass);
        return setResultSuccessData(allCourseClass);
    }
}
