package org.example.aop.aspect.LogAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;
import org.example.aop.annotation.LogExecution.LogExecution;

@Aspect
@Component
public class LogAspect {

    @Before("@annotation(org.example.java.demo.aop.annotation.LogExecution)")
    public void logAnnotationBefore(JoinPoint joinPoint) {
        System.out.println("➡️ Вызван метод: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "@annotation(org.example.java.demo.aop.annotation.LogExecution)", returning = "result")
    public void logAnnotationAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("⬅️ Метод завершён: " + joinPoint.getSignature().getName() +
                ", результат: " + result);
    }

    @AfterThrowing(pointcut = "@annotation(org.example.java.demo.aop.annotation.LogExecution)", throwing = "exception")
    public void logAnnotationAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("❌ Ошибка в методе: " + joinPoint.getSignature().getName() +
                ", сообщение: " + exception.getMessage());
    }
}