package com.zz.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zz.base.BaseApiController;
import com.zz.base.BaseResponse;
import com.zz.constant.Constants;
import com.zz.core.cache.LocalCache;
import com.zz.dtoresp.req.EduCourseReqDto;
import com.zz.dtoresp.resp.EduCourseRespDTO;
import com.zz.service.IEduCourseClassService;
import com.zz.service.IEduCourseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author zz
 * @since 2023-10-13
 */
@RestController
@RequestMapping("/course")
@ApiOperation(value = "课程列表", notes = "课程分类")
@Slf4j
public class EduCourseController extends BaseApiController {
    @Resource
    private IEduCourseClassService iEduCourseClassService;
    @Resource
    IEduCourseService iEduCourseService;
    @GetMapping("/getAllCourseList")
    @ApiOperation(value = "查询所有课程列表", notes = "查询所有课程列表")
    public BaseResponse getAllCourseList() {
        List<EduCourseRespDTO> eduCourseRespList = new ArrayList<>();
        eduCourseRespList = LocalCache.get(
                Constants.COURSE_EDUCOURSERESPLIST,
                eduCourseRespList);
        if (CollectionUtils.isEmpty(eduCourseRespList)) {
            log.error("[从缓存中为查找到eduCourseRespList数据]");
            return setResultError("未查找数据");
        }
        return setResultSuccessData(eduCourseRespList);
    }

    @PostMapping("/searchCourseList")
    @ApiOperation(value = "根据条件搜索课程", notes = "根据条件搜索课程")
    public BaseResponse searchCacheCourseList(@RequestBody EduCourseReqDto eduCourseReqDto){
     List<EduCourseRespDTO> eduCourseRespDTOList =  iEduCourseService.searchcacheCourseList(eduCourseReqDto);
        if (eduCourseRespDTOList == null){
            log.error("[根据条件：{}，未查找到数据]", eduCourseReqDto);
            return setResultError("从缓存中未查到数据");
        }
        return setResultSuccessData(eduCourseRespDTOList);
    }
}
