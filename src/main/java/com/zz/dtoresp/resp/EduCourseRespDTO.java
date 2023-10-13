package com.zz.dtoresp.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class EduCourseRespDTO {

    @ApiModelProperty("课程编号")
    @TableId(value = "COURSE_ID", type = IdType.AUTO)
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;


    @ApiModelProperty("课程专业ID")
    private Integer subjectId;

    @ApiModelProperty("课程专业链")
    private String subjectLink;

    @ApiModelProperty("添加时间")
    private LocalDateTime addTime;

    @ApiModelProperty("课程原价格（只显示）")
    private BigDecimal sourcePrice;

    @ApiModelProperty("课程销售价格（实际支付价格）设置为0则可免费观看")
    private BigDecimal currentPrice;

    @ApiModelProperty("课程简介")
    private String title;

    @ApiModelProperty("课程详情")
    private String context;

    @ApiModelProperty("总课时")
    private Integer lessionNum;

    @ApiModelProperty("图片路径")
    private String logo;


    @ApiModelProperty("浏览数量")
    private Integer pageViewcount;

    @ApiModelProperty("有效结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("有效期类型，0：到期时间，1：按天数")
    private Integer losetype;


}
