package com.xingxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxh
 * @since 2021-08-29
 */
@Data
@Accessors(chain = true)
@TableName("dp_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_id", type = IdType.INPUT)
    private Long userId;

    private String userName;

    private String mobile;

    private String address;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
