package com.mcs.be.course.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by mcolombo on 14/12/17.
 */
@Component
@Aspect
public class DebuggingLoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(DebuggingLoggingAspect.class);


    @Around("execution(* com.mcs.be.course..*.*(..))")
    public Object userAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug(
                    "{} {}({}): {} in msec",
                    joinPoint.getTarget().toString(),
                    MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName(),
                    joinPoint.getArgs(),
                    result,
                    System.currentTimeMillis() - start
            );
        }
        return result;
    }
}


