package com.zz.service;

import com.zz.dtoresp.req.EduUserReqDTO;

/**
 * @author zz
 * @ClassName RegisterService
 */
public interface RegisterService {
    boolean register(EduUserReqDTO
                            eduUserReqDTO);
}
