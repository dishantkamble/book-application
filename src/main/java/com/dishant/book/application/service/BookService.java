package com.dishant.book.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.repository.BookRepository;

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

    public void saveBook(Book book) {
        book.setId(UUID.randomUUID());
        book.getAuthor().setId(UUID.randomUUID());
        book.getPrice().setId(UUID.randomUUID());
        this.bookRepository.save(book);
    }
    
    public Book updateBook(Book book) {
        return this.bookRepository.update(book);
    }

    public void deleteBookById(UUID id) {
        this.bookRepository.deleteById(id);
    }
}