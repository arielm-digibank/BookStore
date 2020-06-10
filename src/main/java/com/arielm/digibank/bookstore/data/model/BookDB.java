package com.arielm.digibank.bookstore.data.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table(name = "books")
public class BookDB {

    @Id
    @Column(name = "book_id", nullable = false)
    private long id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;
}
