package com.arielm.digibank.bookstore.service.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
public class Order {
    private long id;
    private Customer customer;
    private Book book;
    private Date orderDate;
}
