package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.data.CustomersRepository;
import com.arielm.digibank.bookstore.data.model.CustomerDB;
import com.arielm.digibank.bookstore.service.CustomersService;
import com.arielm.digibank.bookstore.service.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository repository;

    public long addCustomer(String name, String description) {
        Optional<Long> maxId = repository.getMaxId();
        long newId = maxId.orElse(1L);
        return addCustomer(newId, name, description);
    }

    public long addCustomer(long id, String name, String description) {
        CustomerDB customerDb = CustomerDB.builder().id(id).name(name).description(description).build();
        repository.save(customerDb);
        return customerDb.getId();
    }

    public Customer getById(long id) {
        Optional<CustomerDB> customerDb =  repository.findById(id);
        if (customerDb.isPresent()) return convertToCustomer(customerDb.get());
        else return null;
    }

    private Customer convertToCustomer(CustomerDB customerDb) {
        return Customer.builder()
                .id(customerDb.getId())
                .name(customerDb.getName())
                .description(customerDb.getDescription())
                .build();
    }
}
