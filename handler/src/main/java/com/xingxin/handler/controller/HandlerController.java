package com.xingxin.handler.controller;

import com.xingxin.handler.GatewayHandler;
import com.xingxin.handler.factory.FactoryHandler;
import com.xingxin.handler.impl.CurrentLimitHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@RestController
public class HandlerController {

    @GetMapping("/clientHandler")
    public String clientHandler() {
        CurrentLimitHandler firstGatewayHandler = FactoryHandler.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}
