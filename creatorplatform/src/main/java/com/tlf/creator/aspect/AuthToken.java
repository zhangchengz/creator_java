package com.tlf.creator.aspect;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {

    /**
     * role 角色名
     * @return
     */
    String role_name() default "";
}