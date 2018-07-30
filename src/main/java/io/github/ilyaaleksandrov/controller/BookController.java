package io.github.ilyaaleksandrov.controller;

import io.github.ilyaaleksandrov.model.Book;
import io.github.ilyaaleksandrov.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable int id){
        Book book = bookService.getBook(id);
        return book;
    }

    @RequestMapping(value = "books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        book.setId(0);
        bookService.addBook(book);
        return book;
    }

    @RequestMapping(value = "books", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return book;
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable int id){
        bookService.removeBook(id);
        return "Deleted book id " + id;
    }
}
