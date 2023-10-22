package com.zz.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.PageUtil;
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
import java.util.HashMap;
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
        Integer totalSize = eduCourseRespDTOList.size();
        Integer totalPage = PageUtil.totalPage(totalSize, Constants.DEFAULT_PAGE_SIZE);
        int pageNo = eduCourseReqDto.getPageNo();
        if (!(pageNo <= totalPage)) {
            log.error("[pageNo参数传递错误] {}", pageNo);
            return setResultError("[pageNo参数传递错误]");
        }
        // 分页，索引小于等于总页数，才返回列表
        //核心
        List<EduCourseRespDTO> listPageEduCourses = CollUtil.page(pageNo - 1, Constants.DEFAULT_PAGE_SIZE,
                eduCourseRespDTOList);
        // 返回最终数据
        HashMap result = new HashMap();
        result.put("pageNo", pageNo); //当前页面
        result.put("pageSize", Constants.DEFAULT_PAGE_SIZE); // 每页条数
        result.put("total", totalSize); // 总记录数
        result.put("totalPage", totalPage); // 总页数
        result.put("listPageEduCourses", listPageEduCourses); // 分页后数据
        return setResultSuccessData(result);
    }
}
