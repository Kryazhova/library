package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findAllByAuthor_Id(Long authorId);

    List<Book> findAllByUser_Id(Long userId);

    Book getById(Long bookId);

}
