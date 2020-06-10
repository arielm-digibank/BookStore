package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.data.OrdersRepository;
import com.arielm.digibank.bookstore.data.model.OrderDB;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.CustomersService;
import com.arielm.digibank.bookstore.service.OrdersService;
import com.arielm.digibank.bookstore.service.domain.Book;
import com.arielm.digibank.bookstore.service.domain.Customer;
import com.arielm.digibank.bookstore.service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private BooksService booksService;

    @Autowired
    private CustomersService customersService;

    public List<Order> getOrdersByCustomer(long customerId) {
        List<OrderDB> orderDbs =  ordersRepository.findByCustomerId(customerId);
        return orderDbs.stream().map(this::convertToOrder).collect(Collectors.toList());
    }

    public Order getOrder(long id) {
        Optional<OrderDB> orderDb =  ordersRepository.findById(id);
        if (orderDb.isPresent()) return convertToOrder(orderDb.get());
        else return null;
    }

    public long addOrder(long bookId, long customerId) {
        Optional<Long> maxId = ordersRepository.getMaxId();
        long newId = maxId.orElse(0L)+1;
        OrderDB orderDb = OrderDB.builder().id(newId).bookId(bookId).customerId(customerId).orderDate(new Date()).build();
        ordersRepository.save(orderDb);
        return newId;
    }

    private Order convertToOrder(OrderDB orderDb) {
        Book book = booksService.getById(orderDb.getId());
        Customer customer = customersService.getById(orderDb.getId());
        return Order.builder()
                .id(orderDb.getId())
                .book(book)
                .customer(customer)
                .orderDate(orderDb.getOrderDate())
                .build();
    }

}