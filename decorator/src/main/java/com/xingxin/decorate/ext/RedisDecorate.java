package com.xingxin.decorate.ext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingxin.decorate.AbstractDecorate;
import com.xingxin.decorate.ComponentCache;
import com.xingxin.decorate.impl.JvmComponentCache;
import com.xingxin.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/29
 */
@Component
public class RedisDecorate extends JvmComponentCache implements AbstractDecorate {

    @Autowired
    private StringRedisTemplate redisTemplate;

//    @Autowired
//    private JvmComponentCache jvmComponentCache;

    @Override
    public <T> T getCacheEntity(String key, Class<T> t, ProceedingJoinPoint joinPoint) {
        // 查询二级缓存redis(装饰者模式的只做增强不做修改)
        String str = redisTemplate.opsForValue().get(key);
        T redisT = JSONObject.parseObject(str, t);
        if (redisT != null) {
            return redisT;
        }
        // 查询一级缓存jvm
        T jvmT = super.getCacheEntity(key, t, joinPoint);
        if (jvmT == null) {
            return null;
        }
        redisTemplate.opsForValue().set(key, JSON.toJSONString(jvmT));
        return jvmT;
    }
}
