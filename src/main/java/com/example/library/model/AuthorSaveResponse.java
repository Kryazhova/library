package com.example.library.model;

import com.example.library.entity.Author;

import java.io.Serializable;

public class AuthorSaveResponse implements Serializable {

    private Author author;
    private long id;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthorSaveResponse{" +
                "author=" + author +
                ", id=" + id +
                '}';
    }
}
