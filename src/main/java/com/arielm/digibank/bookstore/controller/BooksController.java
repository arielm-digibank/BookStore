package com.arielm.digibank.bookstore.controller;

import com.arielm.digibank.bookstore.controller.dto.BookDTO;
import com.arielm.digibank.bookstore.controller.dto.ErrorDTO;
import com.arielm.digibank.bookstore.service.BooksService;
import com.arielm.digibank.bookstore.service.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "books", produces = {APPLICATION_JSON_VALUE})
public class BooksController {

    @Autowired
    BooksService booksService;

    @RequestMapping(value = "/", method = RequestMethod.POST ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public long addBook(@RequestBody BookDTO bookDTO)
    {
       return bookDTO.getId() == 0 ? booksService.addBook(bookDTO.getName(), bookDTO.getAuthor()) :
               booksService.addBook(bookDTO.getId(), bookDTO.getName(), bookDTO.getAuthor());
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return booksService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Book> getBookById(@PathVariable String name) {
        return booksService.getByName(name);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        return booksService.getByAuthorName(author);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorDTO handleException(Exception ex) {
        return new ErrorDTO("Error Occurred: " + ex.getMessage());
    }
}
