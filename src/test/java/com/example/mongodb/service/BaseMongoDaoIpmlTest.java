package com.example.mongodb.service;


import com.alibaba.fastjson.JSON;
import com.example.mongodb.Main;
import com.example.mongodb.common.mongo.SortUitl;
import com.example.mongodb.entity.Order;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class BaseMongoDaoIpmlTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void save() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setOrderNo(UUID.randomUUID().toString());
            order.setNum(new Random().nextInt(100));
            order.setPrice(new BigDecimal(new Random().nextInt(100)));
            orderService.save(order);
        }
    }

    @Test
    public void find() {
        Query query = new Query();
        query.skip(2);
        query.limit(5);
//        List<Order> orderList = BaseMongoDao.find(query, Order.class);
//        for (Order order : orderList) {
//            System.out.println(order);
//        }
    }

    @Test
    public void findAll() {
        Map<String, Object> params = new HashMap<>();
        //params.put("price" , "51");
        List<Order> orderList = orderService.findAll(params, SortUitl.desc("price"));
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void findById() {
        Order order = orderService.findById("5d26a88bfb70413c206ce17d");
        System.out.println(order);
    }

    @Test
    public void findOne() {
        Order order = new Order();
        order.setNum(73);
        Map<String, Object> param = JSON.parseObject(JSON.toJSONString(order), Map.class);
        order = orderService.findOne(param);
        System.out.println(order);
    }

    @Test
    public void upsert() {
        Map<String, Object> params = new HashMap<>();
        params.put("price", "15");
        params.put("num", 57);

        Map<String, Object> data = new HashMap<>();
        data.put("price", "100");
        data.put("num", 88);
        UpdateResult result = orderService.upsert(params, data);
        System.out.println(result.getMatchedCount());
    }

    @Test
    public void remove() {
        Map<String, Object> params = new HashMap<>();
        params.put("price", "42");
        params.put("num", 93);
        DeleteResult result = orderService.remove(params);
        System.out.println(result.getDeletedCount());
    }

    @Test
    public void exists() {
        Map<String, Object> params = new HashMap<>();
        params.put("num", 57);
        System.out.println(orderService.exists(params));
    }

    @Test
    public void dropCollection() {
    }

    @Test
    public void count() {
        Map<String, Object> params = new HashMap<>();
        params.put("num", 2);
        long count = orderService.count(params);
        System.out.println(count);
    }

}