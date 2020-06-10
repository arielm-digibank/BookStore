package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.BookstoreApplication;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.CustomersService;
import com.arielm.digibank.bookstore.service.OrdersService;
import com.arielm.digibank.bookstore.service.domain.Customer;
import com.arielm.digibank.bookstore.service.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(classes = {BookstoreApplication.class },
        properties = {"spring.jpa.hibernate.ddl-auto=none","spring.h2.console.enabled=true","spring.h2.console.path=/h2"},
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrdersServiceImplItTest {

    @Autowired
    OrdersService ordersService;

    @Autowired
    BooksService booksService;

    @Autowired
    CustomersService customersService;

    @Test
    public void testAddCustomer() {
        long custId = customersService.addCustomer(1L, "ariel", "ariel malik");
        long bookId = booksService.addBook(1L, "Esav", "Meir Shalev");
        long orderId = ordersService.addOrder(1L, 1L);

        Order order = ordersService.getOrder(orderId);
        assertEquals("ariel", order.getCustomer().getName());

        List<Order> ordersByCustomer = ordersService.getOrdersByCustomer(custId);
        assertEquals("ariel", ordersByCustomer.get(0).getCustomer().getName());
    }

}
