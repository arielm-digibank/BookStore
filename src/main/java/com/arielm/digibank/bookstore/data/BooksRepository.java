package com.arielm.digibank.bookstore.data;

import com.arielm.digibank.bookstore.data.model.BookDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<BookDB, Long> {

    @Query(value = "select MAX(b.BOOK_ID) from BOOKS b", nativeQuery = true)
    Optional<Long> getMaxId();

    List<BookDB> findByName(String name);

    List<BookDB> findByAuthor(String author);
}
