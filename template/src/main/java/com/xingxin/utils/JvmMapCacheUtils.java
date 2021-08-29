package com.xingxin.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * jvm 内存缓存模型
 *
 * @author liuxh
 * @date 2021/8/28
 */
public class JvmMapCacheUtils {

    public static Map<String, String> caches = new ConcurrentHashMap<>();

    public <T> T getEntity(String key, Class<T> t) {
        String json = caches.get(key);
        return JSONObject.parseObject(json, t);
    }

    public void putEntity(String key, Object o) {
        String json = JSON.toJSONString(o);
        caches.put(key, json);
    }
}
