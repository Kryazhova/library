package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public Controller(BookRepository bookRepository, AuthorRepository authorRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/library/users/{userId}/books")
    public List<Book> getAllBooks(@PathVariable Long userId) {
        return bookRepository.findAllByUser_Id(userId);
    }

    @GetMapping("/library/authors/{authorId}/books")
    public List<Book> getAllBooksFromAuthor(@PathVariable Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

    @GetMapping("/library/authors/{authorId}/users")
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