package com.xingxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xingxin.observer.ObServerSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/8/31
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private ObServerSubject obServerSubject;

    @GetMapping("/creatOrder")
    public String creatOrder() {
        log.info("creatOrder success! message sending...");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "17788700005");
        jsonObject.put("email", "lxh177005@163.com");
        obServerSubject.notifyObServers(jsonObject);
        return "success";
    }

}
