package com.holddie.service;

import com.holddie.entity.Order;

public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}