package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.data.BooksRepository;
import com.arielm.digibank.bookstore.data.model.BookDB;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.domain.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository repository;

    @Autowired
    private DataSource dataSource;

    public long addBook(String name, String author) {
        Optional<Long> maxId = repository.getMaxId();
        long newId = maxId.orElse(1L);
        return addBook(newId, name, author);
    }

    public long addBook(long id, String name, String author) {
        BookDB newBook = BookDB.builder().id(id).name(name).author(author).build();
        repository.save(newBook);
        return newBook.getId();
    }

    public Book getById(long id) {
        Optional<BookDB> bookDb =  repository.findById(id);
        if (bookDb.isPresent()) return convertToBook(bookDb.get());
        else return null;
    }

    public List<Book> getByName(String name) {
        List<BookDB> bookDbs =  repository.findByName(name);

        return bookDbs.stream().map(this::convertToBook).collect(Collectors.toList());
    }

    public List<Book> getByAuthorName(String authorName) {
        List<BookDB> bookDbs =  repository.findByAuthor(authorName);

        return bookDbs.stream().map(this::convertToBook).collect(Collectors.toList());
    }

    private Book convertToBook(BookDB bookDb) {
        return Book.builder()
                .id(bookDb.getId())
                .name(bookDb.getName())
                .author(bookDb.getAuthor())
                .build();
    }
}
