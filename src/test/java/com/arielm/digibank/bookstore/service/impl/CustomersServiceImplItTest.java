package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.BookstoreApplication;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.CustomersService;
import com.arielm.digibank.bookstore.service.domain.Book;
import com.arielm.digibank.bookstore.service.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(classes = {BookstoreApplication.class },
        properties = {"spring.jpa.hibernate.ddl-auto=none","spring.h2.console.enabled=true","spring.h2.console.path=/h2"},
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomersServiceImplItTest {

    @Autowired
    CustomersService customersService;

    @Test
    public void testAddCustomer() {
        long custId = customersService.addCustomer("ariel", "ariel malik");
        Customer cust = customersService.getById(custId);
        assertEquals("ariel", cust.getName());
    }


}
