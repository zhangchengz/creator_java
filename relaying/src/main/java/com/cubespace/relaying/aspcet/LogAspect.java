package com.cubespace.relaying.aspcet;

import com.cubespace.relaying.common.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面类
 * @author zhangc
 * @date 2019/9/16
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 表示包及子包 该方法代表controller层的所有方法
     */
    @Pointcut("execution(public * com.cubespace.relaying.controller..*.*(..))")
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("request --> IP : [{}], URL : [{}], CLASS_METHOD : [{}]",
                request.getRemoteAddr(), request.getRequestURI(),
                joinPoint.getSignature().getDeclaringTypeName() + "."+joinPoint.getSignature().getName());
    }


    @AfterReturning(returning = "result", pointcut = "controllerMethod()")
    public void logResultVOInfo(JsonResult result) {
        logger.info("response --> CODE : [{}], MES : [{}]" ,result.getCode() , result.getMsg());
    }

}