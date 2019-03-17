package com.example.mongodb.service.impl;

import com.example.mongodb.Main;
import com.example.mongodb.entity.Order;
import com.example.mongodb.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class OrderServiceIpmlTest {
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
        List<Order> orderList = orderService.find(query, Order.class);
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void findAll() {
        List<Order> orderList = orderService.findAll(Order.class);
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void findById() {
        Query query = new Query();
        Order order = orderService.findById("5c8cad96e89ca71dc485746b", Order.class);
        System.out.println(order);
    }

    @Test
    public void findOne() {
        Query query = new Query();
        query.addCriteria(Criteria.where("num").is(88));
        Order order = orderService.findOne(query, Order.class);
        System.out.println(order);
    }

    @Test
    public void upsert() {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").is("75"));
        Update update = new Update();
        update.set("num", 62);
        orderService.upsert(query, update, Order.class);
    }

    @Test
    public void remove() {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").is("17"));
        orderService.remove(query, Order.class);
    }

    @Test
    public void exists() {
        Query query = new Query();
        query.addCriteria(Criteria.where("num").is(88));
        System.out.println(orderService.exists(query, Order.class));
    }

    @Test
    public void dropCollection() {
        orderService.dropCollection("order");
    }

    @Test
    public void count() {
        Query query = new Query();
        long count = orderService.count(query, Order.class);
        System.out.println(count);
    }

    @Test
    public void dropCollection1() {
        orderService.dropCollection(Order.class);
    }
}