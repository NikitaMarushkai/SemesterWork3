package ru.kpfu.itis.group408.marushkai.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Created by unlim_000 on 02.06.2016.
 */
@Aspect
public class ServiceAspect {
    /**
     * Замер времени работы метода и просмотр параметров с которыми он был вызван
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start invoking "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End invoking method: " + (end - start) + "ms");
        return result;
    }
}
