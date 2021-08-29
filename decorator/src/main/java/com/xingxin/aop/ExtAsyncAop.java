package com.xingxin.aop;

import com.xingxin.decorate.XingxinCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author liuxh
 * @date 2021/8/29
 */
@Slf4j
@Aspect
@Component
public class ExtAsyncAop {

    @Autowired
    private XingxinCache xingxinCache;

    /**
     *  使用aop拦截方法上使用@ExtMeiteCache自定义的缓存注解
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.xingxin.aop.ExtXingxinCache)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        // 获取目标方法
        Method targetMethod = methodSignature.getMethod();
        // 拼接缓存key
        String key = targetMethod.getName() + Arrays.toString(targetMethod.getParameterTypes())
                + Arrays.toString(joinPoint.getArgs());
        // 目标返回实体类
        Class<?> t = targetMethod.getReturnType();
        return xingxinCache.getCacheEntity(key, t, joinPoint);
    }
}
