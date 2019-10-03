package com.dishant.book.application.service;

import java.util.List;
import java.util.UUID;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.repository.BookRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(UUID id) {
        return this.bookRepository.findById(id);
    }
}