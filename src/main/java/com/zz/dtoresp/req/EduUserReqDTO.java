package com.zz.dtoresp.req;

import lombok.Data;

/**
 * @author zz
 * @ClassName RegisterReqDTO
 */
@Data
public class EduUserReqDTO {
    /**
     * 用户名称
     */
    String userName;
    /**
     * 用户密码
     */
    String password;
}