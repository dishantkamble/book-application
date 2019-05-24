package com.dishant.book.application.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = { "books" })
@AllArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    @GetMapping
    @ApiOperation(value = "Get all books", nickname = "getAllBooks")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get book by Id", nickname = "getBookById")
    public Book getBookById(@PathVariable String id) {
        return this.bookService.getBookById(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Save book", nickname = "saveBook")
    public void saveBook(@RequestBody Book book) {
        this.bookService.saveBook(book);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update book", nickname = "updateBook")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return this.bookService.updateBook(book);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete book by Id", nickname = "deleteBookById")
    public void deleteBookById(@PathVariable String id) {
        this.bookService.deleteBookById(UUID.fromString(id));
    }
}