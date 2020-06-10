package com.arielm.digibank.bookstore.data.model;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table(name = "orders")
public class OrderDB {

    @Id
    @Column(name = "order_id", nullable = false)
    private long id;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "book_id", nullable = false)
    private long bookId;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;
}
