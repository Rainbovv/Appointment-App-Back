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
    public <T> Object logging(ProceedingJoinPoint pJoinPoint) {

        Object object = null;

        switchLogger(pJoinPoint.getSignature().getDeclaringTypeName());
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
            object = pJoinPoint.proceed();
        }
        catch (Throwable exception) {
            switchLogger(pJoinPoint.getSignature().getDeclaringTypeName());
            logger.error(exception.getMessage()+"\n");
        }
        switchLogger(pJoinPoint.getSignature().getDeclaringTypeName());
        logger.info(timeStamp + " - Method " + methodName +" - Returning value: " + object + "\n");

        return object;
    }

    private void switchLogger(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }
}
