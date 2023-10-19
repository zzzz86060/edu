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
 * @since 2023-10-18
 */
@TableName("edu_user")
@ApiModel(value = "EduUser对象", description = "")
@Data
public class EduUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学员ID")
      @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码盐值")
    private String userSalt;

    @ApiModelProperty("显示名 （昵称）")
    private String showName;

    @ApiModelProperty("性别  1男  2女")
    private Boolean sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否可用 1正常  2冻结")
    private Boolean isAvalible;

    @ApiModelProperty("用户头像")
    private String picImg;

    @ApiModelProperty("个人中心用户背景图片")
    private String bannerUrl;

    private String qqOpenid;

    @ApiModelProperty("会员卡ids")
    private String memberCardIds;

    private String wxOpenId;

    private String qq;

    private LocalDateTime updateTime;

}
