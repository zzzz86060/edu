package com.zz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zz
 * @since 2023-10-22
 */
@TableName("user_login_log")
@ApiModel(value = "UserLoginLog对象", description = "")
@Data
public class UserLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;
    public  UserLoginLog(){

    }
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String loginIp;

    private Date loginTime;

    private String loginToken;

    @ApiModelProperty("渠道")
    private String channel;

    @ApiModelProperty("设备信息")
    private String equipment;

    private Integer isDelete;


    public UserLoginLog(Integer userId, String loginIp, Date loginTime, String loginToken,
                        String equipment) {
        this.userId = userId;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.loginToken = loginToken;
        this.equipment = equipment;
    }
}
