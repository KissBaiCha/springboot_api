package com.ly.config;

import com.ly.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * ClassName: MyAppPropertiesConfiguration
 * Package: com.chixing.config
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/6 - 19:30
 * @Version : 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserBeanFactory {
    private final List<User> properties = new ArrayList<>();

    public List<User> getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        Executors.newSingleThreadScheduledExecutor();
    }
}
