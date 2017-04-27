package com.pavelrudenok99999.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavel on 20.04.17.
 */

@Aspect
public class LoggingAspect {

    private Map<Class<?>, Integer> loggersMapCount = new HashMap<>();

    @Pointcut("execution(* EventLogger.logEvent(..))")
    private void allLogEventMethods() {}

    @After("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        Class<?> cls = joinPoint.getTarget().getClass();
        loggersMapCount.put(cls, loggersMapCount.getOrDefault(cls, 0) + 1);
    }

    public Map<Class<?>, Integer> getLoggersMapCount() {
        return loggersMapCount;
    }
}
