package com.codegym.configs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {
    static int countVisitor = 0;

    @Pointcut("execution(* com.codegym.controller.BookController.*(..))")
    public void allMethodPointCut() {
    }

    @Pointcut("execution(* com.codegym.controller.BookController.go*(..))")
    public void crudMethodPointCut() {
    }

    @AfterReturning("allMethodPointCut()")
    public void afterReturningAllMethod(JoinPoint joinPoint) {
        System.err.println("end method name: " + joinPoint.getSignature().getName()
                + "time: " + LocalDate.now());
    }

    @After("allMethodPointCut()")
    public void afterContactAllMethod() {
        System.err.println("numbers of access: " + countVisitor++ + " today !" +
                "time: " + LocalDate.now());
    }

    @AfterReturning("crudMethodPointCut()")
    public void afterReturningCrudMethod(JoinPoint joinPoint) {
        System.err.println("name method contact book made change status: " + joinPoint.getSignature().getName() +
                "time: " + LocalDate.now());
    }
}
