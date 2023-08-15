package com.ly.commons.impl;

import com.ly.commons.inter.IGlobalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: GlobalCache
 * Package: com.ly.commons.impl
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/27 - 10:31
 * @Version : 1.0
 */
@Service
public class GlobalCache implements IGlobalCache {
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean expire(String key, long time) {
        redisTemplate.expire(key,time, TimeUnit.SECONDS);
        return false;
    }

    @Override
    public long getExpire(String key) {
        redisTemplate.getExpire(key,TimeUnit.SECONDS);
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void del(String... keys) {
        redisTemplate.delete(Arrays.asList(keys));
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public boolean set(String key, Object value) {
        return set(key,value,0);
    }

    @Override
    public boolean set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
        return false;
    }

    @Override
    public long incr(String key, long delta) {
        return 0;
    }

    @Override
    public long decr(String key, long delta) {
        return 0;
    }

    @Override
    public Object hget(String key, String item) {
        return null;
    }

    @Override
    public Map<Object, Object> hmget(String key) {
        return null;
    }

    @Override
    public boolean hmset(String key, Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean hmset(String key, Map<String, Object> map, long time) {
        return false;
    }

    @Override
    public boolean hset(String key, String item, Object value) {
        return false;
    }

    @Override
    public boolean hset(String key, String item, Object value, long time) {
        return false;
    }

    @Override
    public void hdel(String key, Object... item) {

    }

    @Override
    public boolean hHasKey(String key, String item) {
        return false;
    }

    @Override
    public double hincr(String key, String item, double by) {
        return 0;
    }

    @Override
    public double hdecr(String key, String item, double by) {
        return 0;
    }

    @Override
    public Set<Object> sGet(String key) {
        return null;
    }

    @Override
    public boolean sHasKey(String key, Object value) {
        return false;
    }

    @Override
    public long sSet(String key, Object... values) {
        return 0;
    }

    @Override
    public long sSetAndTime(String key, long time, Object... values) {
        return 0;
    }

    @Override
    public long sGetSetSize(String key) {
        return 0;
    }

    @Override
    public long setRemove(String key, Object... values) {
        return 0;
    }

    @Override
    public List<Object> lGet(String key, long start, long end) {
        return null;
    }

    @Override
    public long lGetListSize(String key) {
        return 0;
    }

    @Override
    public Object lGetIndex(String key, long index) {
        return null;
    }

    @Override
    public boolean lSet(String key, Object value) {
        return false;
    }

    @Override
    public boolean lSet(String key, Object value, long time) {
        return false;
    }

    @Override
    public boolean lSetAll(String key, List<Object> value) {
        return false;
    }

    @Override
    public boolean lSetAll(String key, List<Object> value, long time) {
        return false;
    }

    @Override
    public boolean rSet(String key, Object value) {
        return false;
    }

    @Override
    public boolean rSet(String key, Object value, long time) {
        return false;
    }

    @Override
    public boolean rSetAll(String key, List<Object> value) {
        return false;
    }

    @Override
    public boolean rSetAll(String key, List<Object> value, long time) {
        return false;
    }

    @Override
    public boolean lUpdateIndex(String key, long index, Object value) {
        return false;
    }

    @Override
    public long lRemove(String key, long count, Object value) {
        return 0;
    }

    @Override
    public void rangeRemove(String key, Long stard, Long end) {

    }

    @Override
    public Set<String> getKeys(String pattern) {
        return null;
    }

    @Override
    public RedisTemplate getRedisTemplate() {
        return null;
    }
}
