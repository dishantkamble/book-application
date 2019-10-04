package com.dishant.book.application.service;

import java.util.UUID;

import com.dishant.book.application.model.Book;
import com.dishant.book.application.repository.BookRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class CatalogService {

    private BookRepository bookRepository;

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
        if (book.getPages() < quantityToSell) {
            log.error("Not enough quantity to sell. Available quantity = " + book.getPages());
            throw new IllegalArgumentException("Not enough quantity to sell. Available quantity = " + book.getPages());
        }
        book.setPages(book.getPages() - quantityToSell);
        return this.bookRepository.update(book);
    }

    public Book addStock(Book book, Long stockToAdd) {
        if (stockToAdd <= 0) {
            log.error("Illegal quantity to add to stock. Entered stock to add = " + stockToAdd);
            throw new IllegalArgumentException(
                    "Illegal quantity to add to stock. Entered stock to add = " + stockToAdd);
        }
        book.setPages(book.getPages() + stockToAdd);
        return this.bookRepository.update(book);
    }
}