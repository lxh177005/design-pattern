package com.xingxin.facade;

import com.xingxin.service.LogService;
import com.xingxin.service.MsgService;
import com.xingxin.service.PaymentService;
import com.xingxin.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@Component
public class PayFacade {

    @Autowired
    private LogService logService;
    @Autowired
    private MsgService msgService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ScoreService scoreService;


    public void facadeCallback() {

        // 1. 收集支付日志
        logService.logService();
        // 2. 修改订单状态
        paymentService.updatePaymentStatus();
        // 3. 增加积分
        scoreService.addScore();
        // 4. 发送消息
        msgService.sendMsg();

    }
}
