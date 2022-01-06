package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
    @Pointcut("execution (* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){};

    //create pointcut for getter methods
    @Pointcut("execution (* com.luv2code.aopdemo.dao.*.get*(..))")
    private void forAllGetters(){};
    //create pointcut for setter methods
    @Pointcut("execution (* com.luv2code.aopdemo.dao.*.set*(..))")
    private void forAllSetters(){};

    @Pointcut("forDaoPackage() && !(forAllGetters() || forAllSetters())")
    private void forDaoPackageNoGettersSetter(){};

    //create pointcut : include package ...exclude getter/setter
    @Before("forDaoPackageNoGettersSetter()u")
    public void perfomAPIAnalytics(){
        System.out.println("\n====> Performing API Analitics");
    }

    @Before("forDaoPackage()")
    private void beforeAddAccountAdvice(){
        System.out.println("\n====> Ececuting @Before advice on method");
    }

}
