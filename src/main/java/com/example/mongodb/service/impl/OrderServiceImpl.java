package com.example.mongodb.service.impl;

import com.example.mongodb.common.mongo.CollectionEnum;
import com.example.mongodb.common.mongo.CriteriaUitl;
import com.example.mongodb.common.mongo.BaseMongoDao;
import com.example.mongodb.common.mongo.UpdateUitl;
import com.example.mongodb.entity.Order;
import com.example.mongodb.service.OrderService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private BaseMongoDao baseMongoDao;

    @Override
    public Order save(Order order) {
        return baseMongoDao.save(order, getCollection());
    }

    @Override
    public Order findById(String id) {
        return baseMongoDao.findById(id, Order.class, getCollection());
    }

    @Override
    public Order findOne(Map<String, Object> parameter) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        if (criteria == null) {
            query = new Query();
        } else {
            query = Query.query(criteria);
        }
        return baseMongoDao.findOne(query, Order.class, getCollection());
    }

    @Override
    public List<Order> findAll(Map<String, Object> params) {
        return findAll(params, null);
    }

    @Override
    public List findAll(Map<String, Object> parameter, Sort sort) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        if (criteria == null) {
            query = new Query();
        } else {
            query = new Query(criteria);
        }
        query.with(sort);
        return baseMongoDao.find(query, Order.class, getCollection());
    }

    @Override
    public UpdateResult upsert(Map<String, Object> parameter, Map<String, Object> data) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        if (criteria == null) {
            query = new Query();
        } else {
            query = new Query(criteria);
        }
        Update update = UpdateUitl.buildUpdate(data);
        return baseMongoDao.upsert(query, update, getCollection());
    }

    @Override
    public DeleteResult remove(Map<String, Object> parameter) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        //criteria不能为空，防止删除全部集合
        if (criteria != null) {
            query = new Query(criteria);
        }
        return baseMongoDao.remove(query, Order.class, getCollection());
    }

    @Override
    public boolean exists(Map<String, Object> parameter) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        if (criteria == null) {
            query = new Query();
        } else {
            query = new Query(criteria);
        }
        return baseMongoDao.exists(query, getCollection());
    }

    @Override
    public long count(Map<String, Object> parameter) {
        Criteria criteria = CriteriaUitl.buildCriteria(parameter);
        Query query = null;
        if (criteria == null) {
            query = new Query();
        } else {
            query = new Query(criteria);
        }
        return baseMongoDao.count(query, getCollection());
    }

    @Override
    public String getCollection() {
        return CollectionEnum.ORDER.getKey();
    }
}
