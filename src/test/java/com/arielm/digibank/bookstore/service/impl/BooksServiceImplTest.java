package com.arielm.digibank.bookstore.service.impl;

import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.domain.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksServiceImplTest {
    @Mock
    private BooksService booksServiceMock = mock(BooksService.class);

    private Book exampleBook = Book.builder().id(1L).name("Esav").author("Meir Shalev").build();

    @Test
    public void getByIdTest() {
        when(booksServiceMock.getById(1L)).thenReturn(exampleBook);
        Book book = booksServiceMock.getById(1L);
        assertEquals("Esav", book.getName());
    }

}
