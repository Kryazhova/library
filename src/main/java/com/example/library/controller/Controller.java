package com.example.library.controller;


import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    private BookRepository bookRepository;

    public Controller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/library/users/{userId}/books")
    public List<Book> getAllBooks(@PathVariable Long userId) {
        return bookRepository.findAllByUser_Id(userId);
    }

    @GetMapping("library/authors/{authorId}/books")
    public List<Book> getAllBooksFromAuthor(@PathVariable Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

    @GetMapping("library/authors/{authorId}/users")
    public List<User> getAllUsersByAuthor(@PathVariable Long authorId) {
        List<Book> books = bookRepository.findAllByAuthor_Id(authorId);
        HashMap<Long, User> users = new HashMap<>();

        books.forEach((book) -> {
            User user = book.getUser();
            if (user != null) {
                users.put(book.getUser().getId(), book.getUser());
            }
        });

        List<User> result = new ArrayList(users.values());

        return result;
    }
}
