package com.zz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@TableName("edu_course")
@Data
@ApiModel(value = "EduCourse对象", description = "课程表")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课程编号")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("1正常2删除")
    private Integer isAvaliable;

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

    @ApiModelProperty("最后更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("销售数量")
    private Integer pageBuycount;

    @ApiModelProperty("浏览数量")
    private Integer pageViewcount;

    @ApiModelProperty("有效结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("有效期类型，0：到期时间，1：按天数")
    private Integer losetype;

    @ApiModelProperty("有效期:商品订单过期时间点")
    private String loseTime;

    @ApiModelProperty("课程资料地址")
    private String courseMaterials;

}
