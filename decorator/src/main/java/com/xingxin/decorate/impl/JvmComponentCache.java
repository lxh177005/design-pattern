package com.xingxin.decorate.impl;

import com.xingxin.decorate.ComponentCache;
import com.xingxin.utils.JvmMapCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/29
 */
@Slf4j
@Component
public class JvmComponentCache implements ComponentCache {

    @Override
    public <T> T getCacheEntity(String key, Class<T> t, ProceedingJoinPoint joinPoint) {
        // 查询一级缓存jvm
        T jvmT = JvmMapCacheUtils.getEntity(key, t);
        if (jvmT != null) {
            return jvmT;
        }
        try {
            // 通用,不再局限与userService了，获取执行方法 即 controller中的userService.getById(id)方法等等
            Object resultDb = joinPoint.proceed();
            if (resultDb == null) {
                return null;
            }
            JvmMapCacheUtils.putEntity(key, resultDb);
            return (T) resultDb;
        } catch (Throwable throwable) {
            log.error("getCacheEntity joinPoint.proceed() throwable :", throwable);
            return null;
        }
    }
}
