package com.arielm.digibank.bookstore.controller;

import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @MockBean
    private BooksService booksService;

    private Book exampleBook = Book.builder().id(1L).name("Esav").author("Meir Shalev").build();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dummyItem_basic() throws Exception {
        when(booksService.getById(1L)).thenReturn(exampleBook);

        RequestBuilder request = MockMvcRequestBuilders.get("/books/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{ id:1, name:\"Esav\", author:\"Meir Shalev\"}" ))
                .andReturn();
        assertEquals("{\"id\":1,\"name\":\"Esav\",\"author\":\"Meir Shalev\"}", result.getResponse().getContentAsString());
    }
}
