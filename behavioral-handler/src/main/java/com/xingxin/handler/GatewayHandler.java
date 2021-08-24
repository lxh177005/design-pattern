package com.xingxin.handler;

/**
 * 在网关作为微服务程序的入口，拦截客户端所有的请求实现权限控制 ，
 * 比如先判断Api接口限流、黑名单、用户会话、参数过滤。
 * Api接口限流→黑名单拦截→用户会话→参数过滤
 * @author liuxh
 * @date 2021/8/22
 */
public abstract class GatewayHandler {

    protected GatewayHandler nextGatewayHandler;
    /**
     * 使用抽象类定义共同方法的行为
     */
    public abstract void service();

    public void setNextGatewayHandler(GatewayHandler gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }

    /**
     *  执行下一个方法
     */
    protected void nextService(){
        if (nextGatewayHandler != null ){
            nextGatewayHandler.service();
        }
    }
}
