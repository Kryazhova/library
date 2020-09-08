package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.model.AuthorSaveResponse;
import com.example.library.model.BookSaveResponse;
import com.example.library.model.UserSaveResponse;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSaveNewInformation {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public ControllerSaveNewInformation(BookRepository bookRepository, AuthorRepository authorRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }


    @PostMapping("/library/authors/save")
    public AuthorSaveResponse saveAuthor(@RequestBody Author request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setSecondName(request.getSecondName());
        author = authorRepository.save(author);

        AuthorSaveResponse response = new AuthorSaveResponse();
        response.setAuthor(author);
        response.setId(author.getId());
        return response;
    }

    @PostMapping("/library/users/save")
    public UserSaveResponse saveUser(@RequestBody User request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setSecondName(request.getSecondName());
        user = userRepository.save(user);

        UserSaveResponse response = new UserSaveResponse();
        response.setUser(user);
        response.setId(user.getId());
        return response;
    }

    @PostMapping("/library/books/save")
    public BookSaveResponse saveBooks(@RequestBody Book request) {
        Book book = new Book();
        book.setBookTitle(request.getBookTitle());
        book.setAuthor(request.getAuthor());
        book = bookRepository.save(book);

        Author author = authorRepository.getById(book.getAuthor().getId());

        BookSaveResponse response = new BookSaveResponse();
        response.setBook(book);
        response.setAuthor(author);
        return response;
    }

}
