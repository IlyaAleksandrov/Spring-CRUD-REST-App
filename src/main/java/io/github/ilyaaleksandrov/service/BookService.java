package io.github.ilyaaleksandrov.service;

import io.github.ilyaaleksandrov.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBook(int id);

    public List<Book> listBooks();
}