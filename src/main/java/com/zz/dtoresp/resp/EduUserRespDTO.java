package com.zz.dtoresp.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zz
 * @ClassName EduUserRespDTO
 */
@Data
public class EduUserRespDTO {
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String userName;
}
