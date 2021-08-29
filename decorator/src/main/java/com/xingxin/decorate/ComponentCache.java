package com.xingxin.decorate;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author liuxh
 * @date 2021/8/29
 */
public interface ComponentCache {

    /**
     *  根据key查缓存数据
     * @param key
     * @param <T>
     * @return
     */
    <T> T getCacheEntity(String key,Class<T> t, ProceedingJoinPoint joinPoint);
}
