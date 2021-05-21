package com.stefanini.appointmentapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogMethodAspect {
    private Logger logger;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Around(value = "@annotation(com.stefanini.appointmentapp.annotation.Loggable)")
    public <T> T logging(ProceedingJoinPoint pJoinPoint) {

        T object = null;

        logger = LoggerFactory.getLogger(pJoinPoint.getSignature().getDeclaringTypeName());
        Object[] args = pJoinPoint.getArgs();
        String methodName = pJoinPoint.getSignature().getName() + "()";
        String timeStamp = "[" + dateFormat.format(new Date()) + "]";

        logger.info(timeStamp
                + " - Executing method "
                + methodName
                + " - With passed args: ");

        for (Object obj : args) {
            logger.info(timeStamp + "- " + obj.toString());
        }
        System.out.println();

        try {
            object = (T) pJoinPoint.proceed();
        }
        catch (Throwable exception) {
            logger.error(exception.getMessage());
        }
        logger = LoggerFactory.getLogger(pJoinPoint.getSignature().getDeclaringTypeName());
        logger.info(timeStamp + " - Method " + methodName +" - Returning value: " + object);
        System.out.println();

        return object;
    }
}
