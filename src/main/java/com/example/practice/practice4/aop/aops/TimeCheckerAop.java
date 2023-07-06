package com.example.practice.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Spring Boot에서 AOP 설정
@Aspect
@Component
public class TimeCheckerAop {
    // com.example.practice.aop.controller 패키지에 있는 모든 컨트롤러에 진입했을 때 실행하라는 설정
    @Pointcut("execution(* com.example.practice.practice4.aop.controller..*.*(..))")
    private void  cut1() {}
    @Pointcut("@annotation(com.example.practice.practice4.aop.annotation.TimeChecker)")
    private void  timeChecker1() {}

    // com.example.practice.aop.controller에서 실행되기 전에 실행하는 메소드
    @Before("cut1() && timeChecker1()")
    public void before(JoinPoint joinPoint) {
        System.out.println(">>>>> Before in TimeCheckerAop is started. <<<<<");
    }

    @Around("cut1() && timeChecker1()")
    public Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // pointcut 실행된 함수를 실행.
        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();
        System.out.println("실행시간: " + stopWatch.getTotalTimeSeconds());

        return result;
    }

}
