package com.xingxin.context;

import com.xingxin.service.OrderState;

/**
 * 使用上下文切换到不同的状态
 *
 * @author liuxh
 * @date 2021/9/4
 */
public class StateContext {

    private OrderState orderState;

    public StateContext(OrderState orderState) {
        this.orderState = orderState;
    }

    public void switchStateOrder() {
        Object o = orderState.orderService();
        System.out.println("o = " + o);
    }
}
