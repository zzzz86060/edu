package com.zz.dtoresp.req;

import lombok.Data;

/**
 * @author zz
 * @ClassName LoginReqDto
 */
@Data
public class LoginReqDto {
    String userName;
    /**
     * 用户密码
     */
    String password;
}
