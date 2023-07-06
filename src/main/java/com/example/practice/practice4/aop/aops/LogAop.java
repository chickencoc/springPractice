package com.example.practice.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.example.practice.practice4.aop.controller.RestApiController.update(..))")
    private void  logPointCut() {}

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println(">>>>> Before in LogAop is started. <<<<<");
    }

}
