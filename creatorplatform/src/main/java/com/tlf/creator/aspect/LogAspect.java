package com.tlf.creator.aspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlf.creator.common.JsonResult;
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
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // ..表示包及子包 该方法代表controller层的所有方法
    @Pointcut("execution(public * com.tlf.creator.controller..*.*(..))")
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        StringBuffer requestLog = new StringBuffer();
//        requestLog.append("IP：[{}], URL: [{}],CLASS_METHOD:[{}]",request.getRemoteAddr(),request.getRequestURI(),joinPoint.getSignature().getName())
//                .append("URL = {" + request.getRequestURI() + "},\t")
//                .append("IP = {" + request.getRemoteAddr() + "},\t")
//                .append("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");
        logger.info("request --> IP : [{}], URL : [{}], COURSE_ID : [{}], CLASS_METHOD : [{}]",request.getRemoteAddr(),request.getRequestURI(),request.getHeader("Cube-Domain"),joinPoint.getSignature().getDeclaringTypeName() + "."+joinPoint.getSignature().getName());
    }


    @AfterReturning(returning = "result", pointcut = "controllerMethod()")
    public void logResultVOInfo(JsonResult result) throws Exception {
        logger.info("response --> CODE : [{}], MES : [{}]" ,result.getCode() , result.getMsg());
    }

}