package com.xingxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xingxin.event.CreatOrderEvent;
import com.xingxin.observer.ObServerSubject;
import com.xingxin.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuxh
 * @date 2021/8/31
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private ObServerSubject obServerSubject;

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/creatOrder")
    public String creatOrder() {
        log.info("creatOrder success! message sending...");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "17788700005");
        jsonObject.put("email", "lxh177005@163.com");
        // 手写observer
        obServerSubject.notifyObServers(jsonObject);
        return "success";
    }

    @GetMapping("/creatOrder2")
    public String creatOrder2() {
        log.info("creatOrder success! message sending...");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "17788700005");
        jsonObject.put("email", "lxh177005@163.com");
        // spring提供的事件监听observer
        CreatOrderEvent event = new CreatOrderEvent(jsonObject);
        applicationContext.publishEvent(event);
        return "success";
    }

}
