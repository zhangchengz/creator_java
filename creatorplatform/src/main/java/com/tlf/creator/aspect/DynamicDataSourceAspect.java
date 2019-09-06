package com.tlf.creator.aspect;

import com.tlf.creator.config.DataSourceContextHolder;
import com.tlf.creator.utils.DBUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 切换数据源切面类
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Autowired
    private DBUtil dbUtil;

    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point) {
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i = 0, len = parameterNames.length; i < len; i++) {
            if (parameterNames[i].equals("courseId")) {
                String courseAlias = dbUtil.getCourseAlias(args[i].toString());
                dataSource = courseAlias;
            }
        }
        DataSourceContextHolder.clearDB();
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }


    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDB();

    }
}
