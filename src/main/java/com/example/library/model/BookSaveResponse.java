package com.example.library.model;

import com.example.library.entity.Author;
import com.example.library.entity.Book;

import java.io.Serializable;

public class BookSaveResponse implements Serializable {
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    public void setAuthor(Author author) {
        this.book.setAuthor(author);
    }

    @Override
    public String toString() {
        return "BookSaveResponse{" + '}';
    }
}
