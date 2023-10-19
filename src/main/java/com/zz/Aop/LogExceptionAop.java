package com.zz.Aop;

import com.zz.base.BaseApiController;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zz
 * @ClassName LogExceptionAop
 */
@Aspect
@Component
@Slf4j
public class LogExceptionAop extends BaseApiController {
    @Around(value = "execution(public * com.zz.controller..*.*(..))")
    public Object currentLimit(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        }
        catch (Exception e) {
            log.error("e:{}", e);
            return setResultError();
        }

    }
}
