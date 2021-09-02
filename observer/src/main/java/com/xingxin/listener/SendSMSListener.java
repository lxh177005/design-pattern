package com.xingxin.listener;


import com.xingxin.event.CreatOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendSMSListener {

    @EventListener(CreatOrderEvent.class)
    @Order(2)
    public void sendSMS(CreatOrderEvent event) {
        log.info("sendSMS:" + event);
    }
}
