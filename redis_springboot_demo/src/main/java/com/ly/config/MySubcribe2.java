package com.ly.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * ClassName: MySubcribe2
 * Package: com.ly.config
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/28 - 09:50
 * @Version : 1.0
 */
@Component
@Slf4j
public class MySubcribe2 implements MessageListener{
    @Override
    public void onMessage(Message message, byte[] pattern) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        String deserialize = serializer.deserialize(message.getBody());
        log.info("接收数据:" + deserialize);
        log.info("订阅频道:" + new String(message.getChannel()));
    }
}
