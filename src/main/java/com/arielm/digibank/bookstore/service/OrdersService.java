package com.arielm.digibank.bookstore.service;

import com.arielm.digibank.bookstore.service.domain.Order;

import java.util.List;

public interface OrdersService {
    List<Order> getOrdersByCustomer(long customerId);
    Order getOrder(long id);
    long addOrder(long bookId, long customereId);
}
