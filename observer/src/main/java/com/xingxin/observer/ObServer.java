package com.xingxin.observer;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liuxh
 * @date 2021/8/30
 */
public interface ObServer {

    /**
     *  发消息
     * @param jsonObject
     */
    void sendMsg(JSONObject jsonObject);
}
