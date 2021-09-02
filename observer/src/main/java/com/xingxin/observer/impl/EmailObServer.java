package com.xingxin.observer.impl;

import com.alibaba.fastjson.JSONObject;
import com.xingxin.observer.ObServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/30
 */
@Component
@Slf4j
public class EmailObServer implements ObServer {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        log.info("观察者模式发送邮件...");
    }
}
