package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.BookstoreApplication;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(classes = {BookstoreApplication.class },
        properties = {"spring.jpa.hibernate.ddl-auto=none","spring.h2.console.enabled=true","spring.h2.console.path=/h2"},
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookServiceImplItTest {

    @Autowired
    BooksService booksService;

    @Test
    public void apiTest() {
        booksService.addBook(1L, "Esav", "Meir Shalev");
        Book book = booksService.getById(1L);
        assertEquals("Esav", book.getName());

        Book notFoundBook = booksService.getById(2L);
        assertEquals(null, notFoundBook);

        Book book2 = booksService.getByName("Esav").get(0);
        assertEquals(1L, book2.getId());

        Book book3 = booksService.getByAuthorName("Meir Shalev").get(0);
        assertEquals(1L, book2.getId());
    }


}
