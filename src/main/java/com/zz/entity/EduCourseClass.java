package com.zz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zz
 * @since 2023-10-11
 */
@TableName("edu_course_class")
@ApiModel(value = "EduCourseClass对象", description = "")
@Data
public class EduCourseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("该表是为class 分类表")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String className;

    private Integer classParentId;

    private String url;

    private LocalDateTime createTime;

    private Integer isDelete;

}
