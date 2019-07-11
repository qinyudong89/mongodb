package com.example.mongodb.util;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: 操作MongoDB工具类
 * @date
 */
@Component
public class MongoUtil extends MongoTemplate {

    public MongoUtil(MongoDbFactory mongoDbFactory) {
        super(mongoDbFactory);
    }
}
