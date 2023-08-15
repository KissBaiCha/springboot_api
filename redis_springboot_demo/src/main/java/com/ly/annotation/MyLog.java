package com.ly.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: MyLog
 * Package: com.ly.annotation
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/8/15 - 17:06
 * @Version : 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

}
