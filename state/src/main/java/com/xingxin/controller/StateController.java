package com.xingxin.controller;

import com.xingxin.context.StateContext;
import com.xingxin.service.OrderState;
import com.xingxin.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@RestController
@Slf4j
public class StateController {

    @GetMapping("/orderState")
    public String orderState(String beanId) {
        // 从spring容器中拿到orderStats
        OrderState orderState = SpringUtils.getBean(beanId, OrderState.class);
        // 使用上下文切换到不同的状态
        StateContext stateContext = new StateContext(orderState);
        stateContext.switchStateOrder();

        log.info("====================");
        orderState.orderService();
        // 如果写多重if判断，整个代码流程耗时长，直接spring中定位到策略或者状态的话 map的get获取 效率高
        return "success";
    }
}
