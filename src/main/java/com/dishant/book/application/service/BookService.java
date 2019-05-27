package com.dishant.book.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.repository.BookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    public Book sellBooks(Book book, Long quantityToSell) {
        if (book.getQuantity() < quantityToSell) {
            log.error("Not enough quantity to sell. Available quantity = " + book.getQuantity());
            throw new IllegalArgumentException(
                    "Not enough quantity to sell. Available quantity = " + book.getQuantity());
        }
        book.setQuantity(book.getQuantity() - quantityToSell);
        return this.bookRepository.update(book);
    }

    public Book addStock(Book book, Long stockToAdd) {
        if (stockToAdd <= 0) {
            log.error("Illegal quantity to add to stock. Entered stock to add = " + stockToAdd);
            throw new IllegalArgumentException(
                    "Illegal quantity to add to stock. Entered stock to add = " + stockToAdd);
        }
        book.setQuantity(book.getQuantity() + stockToAdd);
        return this.bookRepository.update(book);
    }
}