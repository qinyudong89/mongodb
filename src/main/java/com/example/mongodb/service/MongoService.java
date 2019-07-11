package com.example.mongodb.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public interface MongoService {

    /**
     * 新增或更新
     *
     * @param objectToSave
     * @param <T>
     * @return
     */
    <T> T save(T objectToSave);

    /**
     * 获取所有符合条件的集合
     *
     * @param query       条件
     * @param entityClass 接收类型
     * @param <T>
     * @return
     */
    <T> List<T> find(Query query, Class<T> entityClass);

    /**
     * 获取所有集合
     *
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> List<T> findAll(Class<T> entityClass);

    /**
     * 根据ID获取集合
     *
     * @param id
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> T findById(Object id, Class<T> entityClass);

    /**
     * 获取第一个配置的集合
     *
     * @param query
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> T findOne(Query query, Class<T> entityClass);

    /**
     * 存在则更新，否则新增
     *
     * @param query
     * @param update
     * @param entityClass
     * @return
     */
    UpdateResult upsert(Query query, Update update, Class<?> entityClass);

    /**
     * 删除
     *
     * @param query
     * @param entityClass
     * @return
     */
    DeleteResult remove(Query query, Class<?> entityClass);

    /**
     * 删除表
     *
     * @param entityClass
     * @param <T>
     */
    <T> void dropCollection(Class<T> entityClass);

    /**
     * 删除表
     *
     * @param collectionName
     */
    void dropCollection(String collectionName);

    /**
     * 判断集合是否有指定的值
     *
     * @param query
     * @param entityClass
     * @return
     */
    boolean exists(Query query, Class<?> entityClass);

    /**
     * 获取记录数
     *
     * @param query
     * @param entityClass
     * @return
     */
    long count(Query query, Class<?> entityClass);
}
