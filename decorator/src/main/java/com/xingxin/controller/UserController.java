package com.xingxin.controller;


import com.xingxin.aop.ExtXingxinCache;
import com.xingxin.decorate.ext.RedisDecorate;
import com.xingxin.entity.User;
import com.xingxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuxh
 * @since 2021-08-29
 */
@RestController
@RequestMapping("/user")
//@ExtXingxinCache
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisDecorate redisDecorate;

//    @GetMapping("/getUser")
//    public ResponseEntity<User> getUser(Long id) {
//        String key = "get_user_" + id;
////        // 先查二级缓存redis
////        String str = redisTemplate.opsForValue().get(key);
////        User redisUser = JSONObject.parseObject(str, User.class);
////        if (redisUser != null) {
////            return ResponseEntity.ok(redisUser);
////        }
////        // 再查一级缓存jvm
////        User jvmUser = JvmMapCacheUtils.getEntity(key, User.class);
////        if (jvmUser != null) {
////            // 将一级缓存放入二级缓存中
////            redisTemplate.opsForValue().set(key, JSON.toJSONString(jvmUser));
////            return ResponseEntity.ok(jvmUser);
////        }
////        // 最后查db
////        User dbUser = userService.getById(id);
////        if (dbUser == null) {
////            return null;
////        }
////        JvmMapCacheUtils.putEntity(key, dbUser);
////        return ResponseEntity.ok(dbUser);
//
//        User user = redisDecorate.getCacheEntity(key);
//        return ResponseEntity.ok(user);
//    }

    @GetMapping("/getUser")
    @ExtXingxinCache
    public User getUser(Long id) {
        return userService.getById(id);
    }
}

