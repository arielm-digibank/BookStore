package com.arielm.digibank.bookstore.data;

import com.arielm.digibank.bookstore.data.model.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<OrderDB, Long> {

    @Query(value = "select MAX(o.ORDER_ID) from ORDERS o", nativeQuery = true)
    Optional<Long> getMaxId();

    List<OrderDB> findByCustomerId(long customerId);
}
