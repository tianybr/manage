package com.mall.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author bryin
 * @create 2020-05-19 17:14
 */
@Aspect
@Component
@Slf4j
public class ServiceLog {
    @Around("execution(* com.mall.service.impl..*.*(..))")
    public Object recordServiceTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("======{}.{}开始执行======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());
        Long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long takeTime = end - start;
        if(takeTime > 3000){
            log.error("=====执行结束,耗时: {}毫秒=====",takeTime);
        }else if(takeTime > 2000){
            log.warn("=====执行结束,耗时: {}毫秒=====",takeTime);
        }else{
            log.info("=====执行结束,耗时: {}毫秒=====",takeTime);
        }
        return proceed;
    }
}
