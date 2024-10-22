package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Order(3)
@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDoaPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("=======executing before add Account=========");

    }
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount (..))",
    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("======>>Executing after resulting on method"+method);
        System.out.println(result);
        convertAccoutNamestoUpperCase(result);
        System.out.println(result);
    }

    private void convertAccoutNamestoUpperCase(List<Account> result) {
        for(Account temAccount:result){
            String theUpperName=temAccount.getName().toUpperCase();
            temAccount.setName(theUpperName);
        }
    }

}
