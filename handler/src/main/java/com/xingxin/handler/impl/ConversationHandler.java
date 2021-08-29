package com.xingxin.handler.impl;

import com.xingxin.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Slf4j
public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
       log.info("第三关 >> 用户会话拦截....");
       nextService();
    }
}
