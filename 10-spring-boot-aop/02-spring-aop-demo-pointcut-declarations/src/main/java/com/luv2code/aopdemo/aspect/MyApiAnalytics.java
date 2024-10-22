package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class MyApiAnalytics
{
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDoaPackage()")
    public void performApiAnalytics(){
        System.out.println("=========performing api analytics=========");
    }
}
