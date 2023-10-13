package com.zz.dtoresp.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zz
 * @ClassName EduCourseReqDTO
 */
@Data
@Slf4j
public class EduCourseReqDto {
    @ApiModelProperty("课程名称")
    private String courseName;


    @ApiModelProperty("课程专业ID")
    private Integer subjectId;

    @ApiModelProperty("分页")
    private Integer pageNo = 1;
}
