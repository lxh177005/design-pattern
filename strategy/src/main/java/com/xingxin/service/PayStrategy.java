package com.xingxin.service;

import org.springframework.stereotype.Service;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Service
public interface PayStrategy {
    /**
     * 共同算法实现骨架
     */
     String toPayHtml();
}
