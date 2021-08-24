package com.xingxin.handler.entity;

import lombok.Data;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Data
public class GatewayHandlerEntity {
    /** 主键ID */
    private Integer id;
    /** handler名称 */
    private String handlerName;
    /** handler主键id */
    private String handlerId;
    /** 上一个handler */
    private String prevHandlerId;
    /** 下一个handler */
    private String nextHandlerId;
}
