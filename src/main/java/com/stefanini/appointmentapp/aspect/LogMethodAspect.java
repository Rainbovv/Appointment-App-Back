package com.stefanini.appointmentapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogMethodAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(LogMethodAspect.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Pointcut("@annotation(com.stefanini.appointmentapp.annotation.Loggable)")
    public void log() {
    }

    @Before(value = "log()")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        Class<?> executingClass = joinPoint.getThis().getClass();
        Object[] methodParams = joinPoint.getArgs();
        String className = executingClass.getName();
        String methodName = joinPoint.getSignature().getName();
        String timeStamp = "[" + dateFormat.format(new Date()) + "]";

        if (methodParams.length == 0) {
            LOGGER.info(timeStamp
                    + " - Executing before void method: "
                    + methodName
                    + " with passed params: in "
                    + " - [" + className + "]");
        } else {
            LOGGER.info(timeStamp
                    + " - Executing before method: "
                    + methodName
                    + " with passed params: ");

            for (Object obj : methodParams) {
                LOGGER.info(timeStamp + " - " + obj.toString());
            }

            LOGGER.info(timeStamp + " - in " + " - [" + className + "]");
        }
    }

    @After(value = "log()")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        Class<?> executingClass = joinPoint.getThis().getClass();
        Object[] methodParams = joinPoint.getArgs();
        String className = executingClass.getName();
        String methodName = joinPoint.getSignature().getName();
        String timeStamp = "[" + dateFormat.format(new Date()) + "]";

        if (methodParams.length > 0) {
            LOGGER.info(timeStamp
                    + " - Execution after method: "
                    + methodName + " returned params: "
                    + methodParams[0].toString()
                    + " in " + " - [" + className + "]");
        }
    }
}
