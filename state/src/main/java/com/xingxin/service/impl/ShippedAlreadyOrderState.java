package com.xingxin.service.impl;

import com.xingxin.service.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@Slf4j
@Component
public class ShippedAlreadyOrderState implements OrderState {
    @Override
    public Object orderService() {
        log.info(">>>切换为已经发货状态...");
        return "切换为已经发货状态";
    }
}
