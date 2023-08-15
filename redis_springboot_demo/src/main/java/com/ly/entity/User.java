package com.ly.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * ClassName: User
 * Package: com.chixing.entity
 * Description : 在此写入类信息
 *
 * @Author : Xu Zhang
 * @CreateDate : 2023/7/6 - 17:38
 * @Version : 1.0
 */
@Data
@Component
public class User {
    // todo
    private String name;
    private Integer age;
}
