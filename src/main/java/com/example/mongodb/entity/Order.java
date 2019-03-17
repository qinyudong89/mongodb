package com.example.mongodb.entity;

import java.math.BigDecimal;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class Order {
    //订单号
    private String orderNo;
    //价格
    private BigDecimal price;
    //数量
    private Integer num;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
