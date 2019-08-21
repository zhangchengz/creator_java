package com.tlf.creatorconsumer.permission;

import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.resp.ResultResp;
import com.tlf.creatorconsumer.utils.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthTokenAspect {
    /**
     * Spring中使用@Pointcut注解来定义方法切入点
     *
     * @Pointcut 用来定义切点，针对方法
     * @Aspect 用来定义切面，针对类 后面的增强均是围绕此切入点来完成的
     * 此处仅配置被我们刚才定义的注解：AuthToken修饰的方法即可
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    /**
     * 此处我使用环绕增强，在方法执行之前或者执行之后均会执行。
     */
    @Around("doAuthToken(authToken)")
    public Object deBefore(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取访问该方法所需的role_name信息
        String role_name = authToken.role_name();
        //获取token
        String token = request.getHeader("Cube-Token");
        //获取角色信息
        String role = JWTUtil.getRole(token);
        if (token != null) {
            //token校验
            boolean verify = JWTUtil.verify(token);
            if (verify) {
                //权限校验
                if (!StringUtils.isBlank(role_name)) {
                    if (role != null && role.equals(role_name)) {
                        return pjp.proceed();
                    } else {
                        return new ResultResp(Constants.CODE_BAD, "权限不足", null, null);
                    }
                } else {
                    return pjp.proceed();
                }
            } else {
                return new ResultResp(Constants.CODE_BAD, "token校验失败", null, null);
            }
        } else {
            return new ResultResp(Constants.CODE_BAD, "token为空", null, null);
        }
    }

}
