package com.xingxin.listener;


import com.xingxin.event.CreatOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEmailListener {

    @EventListener(CreatOrderEvent.class)
    @Order(1)
    @Async
    public void sendEmail(CreatOrderEvent event) {
        log.info("sendEmail:{}, Thread name: {}", event, Thread.currentThread().getName());
    }
}
