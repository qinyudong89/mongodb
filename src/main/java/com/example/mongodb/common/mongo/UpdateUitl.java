package com.example.mongodb.common.mongo;

import org.springframework.data.mongodb.core.query.Update;

import java.util.Map;

public class UpdateUitl {

    /**
     * 拼接更新条件
     *
     * @param data
     * @return
     */
    public static Update buildUpdate(Map<String, Object> data) {
        Update update = new Update();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            update = update.set(entry.getKey(), entry.getValue());
        }
        return update;
    }
}
