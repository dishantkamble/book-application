package com.dishant.book.application.controller;

import java.util.List;
import java.util.UUID;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}