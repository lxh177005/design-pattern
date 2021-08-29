package com.xingxin.entity;

import lombok.Data;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Data
public class PaymentChannel {
    /**
     * ID
     */
    private Integer id;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 策略执行beanId
     */
    private String strategyBeanId;
}
