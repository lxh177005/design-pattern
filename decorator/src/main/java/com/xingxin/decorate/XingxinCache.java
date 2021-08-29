package com.xingxin.decorate;

import com.xingxin.decorate.ext.RedisDecorate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/29
 */
@Component
public class XingxinCache {
    @Autowired
    private RedisDecorate redisDecorate;

    public <T> T getCacheEntity(String key, Class<T> t, ProceedingJoinPoint joinPoint) {
        return redisDecorate.getCacheEntity(key, t, joinPoint);
    }
}
