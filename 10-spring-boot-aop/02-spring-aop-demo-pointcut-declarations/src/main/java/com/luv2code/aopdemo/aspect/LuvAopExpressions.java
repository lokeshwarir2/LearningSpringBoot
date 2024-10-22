package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDoaPackage(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDoaPackage()&&!(getter()||setter())")
    public void forDoaPackageNoGetterSetter(){}

}
