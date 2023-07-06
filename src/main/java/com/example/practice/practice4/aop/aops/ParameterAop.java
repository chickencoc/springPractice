package com.example.practice.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Spring Boot에서 AOP 설정
@Aspect
@Component
public class ParameterAop {
    // com.example.practice.aop.controller 패키지에 있는 모든 컨트롤러에 진입했을 때 실행하라는 설정
    @Pointcut("execution(* com.example.practice.practice4.aop.controller..*.*(..))")
    private void  cut1() {}

    // com.example.practice.aop.controller에서 실행되기 전에 실행하는 메소드
    @Before("cut1()")
    public void before(JoinPoint joinPoint) {
        System.out.println(">>>>> Before in aop is started. <<<<<");
    }

    @AfterReturning(value = "cut1()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println(">>>>> AfterReturning in aop is started. <<<<<");
    }
}
