package com.xingxin.aop;

import java.lang.annotation.*;

/**
 * 自定义缓存注解， target：范围(method方法，type类) retention：运行时（可以通过反射获取）
 *
 * @author liuxh
 * @date 2021/8/29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtXingxinCache {
}

