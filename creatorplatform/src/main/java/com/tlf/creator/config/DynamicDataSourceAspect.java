package com.tlf.creator.config;

import com.tlf.creator.common.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point){
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //2.获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
//        Method method = methodSignature.getMethod();
//        System.out.println("---------------参数列表开始-------------------------");
        for (int i =0 ,len=parameterNames.length;i < len ;i++){
//            System.out.println("参数名："+ parameterNames[i] + " = " +args[i]);
            if(parameterNames[i].equals("courseId")){
                if(args[i]!=null&&args[i].equals(Constants.COURSE)){
                    dataSource="creatorcourse";
                }
                if(args[i]!=null&&args[i].equals(Constants.COURSE1)){
                    dataSource="creatorcourse1";
                }
            }
        }

//        //获得当前访问的class
//        Class<?> className = point.getTarget().getClass();
//
//        //获得访问的方法名
//        String methodName = point.getSignature().getName();
//        //得到方法的参数的类型
//        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

//        try {
//            // 得到访问的方法对象
//            Method method1 = className.getMethod(methodName, argClass);
//            LocalVariableTableParameterNameDiscoverer u =
//                    new LocalVariableTableParameterNameDiscoverer();
//            String[] params = u.getParameterNames(method);
//            for (int i = 0; i < params.length; i++) {
//                System.out.println();
//            }
//            // 判断是否存在@DS注解
//            if (method.isAnnotationPresent(DS.class)) {


//                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//                HttpServletRequest request = attributes.getRequest();
//                String domain = request.getHeader("Cube-Domain");
//                if(domain!=null&&domain.equals(Constants.COURSE)){
//                    dataSource="creator";
//                }
//                if(domain!=null&&domain.equals(Constants.COURSE1)){
//                    dataSource="creatorcourse1";
//                }
//                if(domain!=null&&domain.equals(Constants.COURSE2)){
//                    dataSource="creatorcourse2";
//                }
//                if(domain!=null&&domain.equals(Constants.COURSE3)){
//                    dataSource="creatorcourse3";
//                }
//                if(domain!=null&&domain.equals(Constants.COURSE4)){
//                    dataSource="creatorcourse4";
//                }
//                if(domain!=null&&domain.equals(Constants.COURSE5)){
//                    dataSource="creatorcourse5";
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        DataSourceContextHolder.clearDB();
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }


    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){

        DataSourceContextHolder.clearDB();

    }
}
