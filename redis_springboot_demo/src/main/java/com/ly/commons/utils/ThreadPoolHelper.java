package com.ly.commons.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池辅助类
 */
public class ThreadPoolHelper {

    /**
     * 创建新的固定线程池，根据参数allowInheritingParentRequest决定是否允许子线程继承父线程的request属性
     * @param threadCount 最大线程数量
     * @return
     */
    public static ExecutorService createFixedThreadPool(int threadCount){
        return Executors.newFixedThreadPool(threadCount);
    }
}
