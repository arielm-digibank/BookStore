package com.arielm.digibank.bookstore.service;

import com.arielm.digibank.bookstore.data.model.CustomerDB;
import com.arielm.digibank.bookstore.service.domain.Customer;

public interface CustomersService {
    long addCustomer(long id, String name, String description);

    long addCustomer(String name, String description);

    Customer getById(long id);
}
