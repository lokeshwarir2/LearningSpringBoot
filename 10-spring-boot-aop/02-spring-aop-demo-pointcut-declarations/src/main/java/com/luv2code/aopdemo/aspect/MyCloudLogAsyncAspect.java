package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class MyCloudLogAsyncAspect {
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDoaPackage()")
    public void logToCloud(){
        System.out.println("=========logging to cloud in async function=========");
    }
}
