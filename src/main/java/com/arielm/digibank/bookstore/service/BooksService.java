package com.arielm.digibank.bookstore.service;

import com.arielm.digibank.bookstore.service.domain.Book;

import java.util.List;

public interface BooksService {
    long addBook(String name, String author);

    long addBook(long id, String name, String author);

    Book getById(long id);

    List<Book> getByName(String name);

    List<Book> getByAuthorName(String authorName);
}
