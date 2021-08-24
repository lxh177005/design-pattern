package com.xingxin.handler.factory;

import com.xingxin.handler.GatewayHandler;
import com.xingxin.handler.impl.BlacklistHandler;
import com.xingxin.handler.impl.ConversationHandler;
import com.xingxin.handler.impl.CurrentLimitHandler;

/**
 * @author liuxh
 * @date 2021/8/22
 */
public class FactoryHandler {

    public static CurrentLimitHandler getFirstGatewayHandler() {
        // 第一关
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        // 第二关
        BlacklistHandler blacklistHandler = new BlacklistHandler();
        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        // 第三关
        ConversationHandler conversationHandler = new ConversationHandler();
        blacklistHandler.setNextGatewayHandler(conversationHandler);
        return currentLimitHandler;
    }
}
