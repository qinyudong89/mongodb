package com.example.mongodb.service;

import com.example.mongodb.entity.Order;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Map;

public interface OrderService {

    Order save(Order order);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Order findById(String id);

    /**
     * 根据条件查询
     *
     * @param parameter
     * @return
     */
    Order findOne(Map<String, Object> parameter);

    /**
     * 获取
     *
     * @param
     * @return
     */
    List<Order> findAll(Map<String, Object> params);

    /**
     * 根据条件获取集合，并排序
     *
     * @param parameter 过滤条件
     * @param sort      属性排序
     * @return
     */
    List findAll(Map<String, Object> parameter, Sort sort);

    /**
     * 根据条件更新
     *
     * @param parameter
     * @param data
     * @return
     */
    UpdateResult upsert(Map<String, Object> parameter, Map<String, Object> data);

    /**
     * 删除
     *
     * @param parameter
     * @return
     */
    DeleteResult remove(Map<String, Object> parameter);

    /**
     * 根据指定条件，查询文档是否存在
     *
     * @param parameter
     * @return
     */
    boolean exists(Map<String, Object> parameter);

    /**
     * 统计符合条件的记录
     *
     * @param parameter
     * @return
     */
    long count(Map<String, Object> parameter);


    /**
     * 获取集合
     *
     * @return
     */
    String getCollection();
}
