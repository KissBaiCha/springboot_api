package com.ly.commons.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: GlobalCacheUtil
 * Package: com.ly.commons.utils
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/27 - 10:56
 * @Version : 1.0
 */
@Component
public class GlobalCacheUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private static RedisTemplate<String,Object> redisTemplateStatic;
    @PostConstruct
    public void init(){
        redisTemplateStatic = redisTemplate;
    }

    public static void del(String key){
        redisTemplateStatic.delete(key);
    }
    public static void del(String... keys){
        redisTemplateStatic.delete(Arrays.asList(keys));
    }
    public static boolean hasKey(String key){
        return Boolean.TRUE.equals(redisTemplateStatic.hasKey(key));
    }
    public static boolean expire(String key, long time) {
        return Boolean.TRUE.equals(redisTemplateStatic.expire(key, time, TimeUnit.SECONDS));
    }
    public static Long getExpire(String key) {
        return redisTemplateStatic.getExpire(key,TimeUnit.SECONDS);
    }
    public static BoundValueOperations<String ,Object> getBoundValueOps(String key){
        return redisTemplateStatic.boundValueOps(key);
    }
    public static void set(String key,Object value){
        redisTemplateStatic.opsForValue().set(key,value);
    }
    public static void set(String key,Object value,long time){
        set(key,value,time,TimeUnit.SECONDS);
    }
    public static void set(String key,Object value,long time,TimeUnit timeUnit){
        redisTemplateStatic.opsForValue().set(key,value,time,timeUnit);
    }
    public static String getString(String key){
        return (String) redisTemplateStatic.opsForValue().get(key);
    }
    public static Object get(String key){
        return redisTemplateStatic.opsForValue().get(key);
    }
    public static void publish(String channel,Object message){
        redisTemplateStatic.convertAndSend(channel,message);
    }
}
