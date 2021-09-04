package com.xingxin.test;

import com.xingxin.context.StateContext;
import com.xingxin.service.impl.AlreadySignedOrderState;
import com.xingxin.service.impl.InTransitOrderState;
import com.xingxin.service.impl.ShippedAlreadyOrderState;

/**
 * @author liuxh
 * @date 2021/9/4
 */
public class StateTest {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext(new AlreadySignedOrderState());
        stateContext.switchStateOrder();

        StateContext stateContext1 = new StateContext(new InTransitOrderState());
        stateContext1.switchStateOrder();

        StateContext stateContext2 = new StateContext(new ShippedAlreadyOrderState());
        stateContext2.switchStateOrder();
    }
}
