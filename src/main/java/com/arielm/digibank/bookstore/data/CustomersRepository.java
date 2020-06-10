package com.arielm.digibank.bookstore.data;

import com.arielm.digibank.bookstore.data.model.CustomerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<CustomerDB, Long> {

    @Query(value = "select MAX(c.CUSTOMER_ID) from CUSTOMERS c", nativeQuery = true)
    Optional<Long> getMaxId();
}
