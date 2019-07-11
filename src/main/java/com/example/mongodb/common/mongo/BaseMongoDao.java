package com.example.mongodb.common.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
@Component
public class BaseMongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public <T> T save(T objectToSave, String collectionName) {
        return mongoTemplate.save(objectToSave, collectionName);
    }

    public <T> T findById(Object id, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findById(id, entityClass, collectionName);
    }

    public <T> T findOne(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findOne(query, entityClass, collectionName);
    }

    public <T> List<T> find(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    public <T> List<T> findAll(Class<T> entityClass, String collectionName) {
        return mongoTemplate.findAll(entityClass, collectionName);
    }

    public UpdateResult upsert(Query query, Update update, Class<?> entityClass) {
        return mongoTemplate.upsert(query, update, entityClass);
    }
    public UpdateResult upsert(Query query, Update update, String collectionName) {
        return mongoTemplate.upsert(query, update, collectionName);
    }
    public DeleteResult remove(Query query, Class<?> entityClass) {
        return mongoTemplate.remove(query, entityClass);
    }

    public DeleteResult remove(Query query, Class<?> entityClass, String collectionName) {
        return mongoTemplate.remove(query, entityClass, collectionName);
    }

    public boolean exists(Query query, Class<?> entityClass) {
        return mongoTemplate.exists(query, entityClass);
    }

    public boolean exists(Query query, String collectionName) {
        return mongoTemplate.exists(query, collectionName);
    }

    public long count(Query query, Class<?> entityClass) {
        return mongoTemplate.count(query, entityClass);
    }

    public long count(Query query, String collectionName) {
        return mongoTemplate.count(query, collectionName);
    }

    public <T> void dropCollection(Class<T> entityClass) {
        mongoTemplate.dropCollection(entityClass);
    }

    public void dropCollection(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }

}
