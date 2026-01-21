package com.example.naxin.annotation;

import java.lang.annotation.*;

/**
 * 权限注解，用于方法或类上声明需要的角色
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireRole {
    /**
     * 允许访问的角色列表
     * @return 角色数组，如 {"ADMIN", "USER"}
     */
    String[] value() default {};
}
