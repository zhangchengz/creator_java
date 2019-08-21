package com.tlf.creatorcourse.config;

import com.tlf.creatorcourse.constants.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point){

        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();

        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DS.class)) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                String domain = request.getHeader("Cube-Domain");
                if(domain!=null&&domain.equals(Constants.COURSE)){
                    dataSource="creatorcourse";
                }
                if(domain!=null&&domain.equals(Constants.COURSE1)){
                    dataSource="creatorcourse1";
                }
                if(domain!=null&&domain.equals(Constants.COURSE2)){
                    dataSource="creatorcourse2";
                }
                if(domain!=null&&domain.equals(Constants.COURSE3)){
                    dataSource="creatorcourse3";
                }
                if(domain!=null&&domain.equals(Constants.COURSE4)){
                    dataSource="creatorcourse4";
                }
                if(domain!=null&&domain.equals(Constants.COURSE5)){
                    dataSource="creatorcourse5";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.clearDB();
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }


    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){

        DataSourceContextHolder.clearDB();

    }
}
