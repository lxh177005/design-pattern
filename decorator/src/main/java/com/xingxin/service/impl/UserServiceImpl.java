package com.xingxin.service.impl;

import com.xingxin.entity.User;
import com.xingxin.dao.UserMapper;
import com.xingxin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxh
 * @since 2021-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
