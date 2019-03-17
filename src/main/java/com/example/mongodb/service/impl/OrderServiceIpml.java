package com.example.mongodb.service.impl;

import com.example.mongodb.service.OrderService;
import com.example.mongodb.util.MongoUtil;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
@Service
public class OrderServiceIpml implements OrderService {
    @Autowired
    private MongoUtil mongoUtil;

    @Override
    public <T> T save(T objectToSave) {
        return mongoUtil.save(objectToSave);
    }

    @Override
    public <T> List<T> find(Query query, Class<T> entityClass) {
        return mongoUtil.find(query, entityClass);
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        return mongoUtil.findAll(entityClass);
    }

    @Override
    public <T> T findById(Object id, Class<T> entityClass) {
        return mongoUtil.findById(id, entityClass);
    }

    @Override
    public <T> T findOne(Query query, Class<T> entityClass) {
        return mongoUtil.findOne(query, entityClass);
    }

    @Override
    public UpdateResult upsert(Query query, Update update, Class<?> entityClass) {
        return mongoUtil.upsert(query, update, entityClass);
    }

    @Override
    public DeleteResult remove(Query query, Class<?> entityClass) {
        return mongoUtil.remove(query, entityClass);
    }

    @Override
    public boolean exists(Query query, Class<?> entityClass) {
        return mongoUtil.exists(query, entityClass);
    }

    @Override
    public <T> void dropCollection(Class<T> entityClass) {
        mongoUtil.dropCollection(entityClass);
    }

    @Override
    public long count(Query query, Class<?> entityClass) {
        return mongoUtil.count(query, entityClass);
    }

    @Override
    public void dropCollection(String collectionName) {
        mongoUtil.dropCollection(collectionName);
    }
}
