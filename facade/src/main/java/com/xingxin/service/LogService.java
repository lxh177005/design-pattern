package com.xingxin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@Slf4j
@Service
public class LogService {

    public void logService() {
        log.info("1.支付日志收集。。。");
    }
}
