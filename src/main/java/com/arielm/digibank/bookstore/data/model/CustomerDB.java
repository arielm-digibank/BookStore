package com.arielm.digibank.bookstore.data.model;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table(name = "customers")
public class CustomerDB {

    @Id
    @Column(name = "customer_id", nullable = false)
    private long id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
}
