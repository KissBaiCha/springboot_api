package com.ly.controller;

import com.ly.commons.utils.GlobalCacheUtil;
import com.ly.config.UserBeanFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xu Zhang
 * @version 1.0
 * @date 2022/9/28 13:43
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserBeanFactory factory;

    @GetMapping("t2")
    @ResponseBody
    public String test2(String message){
        GlobalCacheUtil.publish("channel1",message);
        GlobalCacheUtil.publish("channel2",message);
        return "yes!";
    }

}
