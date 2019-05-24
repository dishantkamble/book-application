package com.dishant.book.application.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.dishant.book.application.model.Book;

@Repository
public class BookRepository extends BaseRepository<Book, UUID> {

    public BookRepository(Map<UUID, Book> persistence) {
        super(persistence);
    }

    @Override
    public List<Book> findAll() {
        return super.findAll();
    }

    @Override
    public Book findById(UUID id) {
        return super.findById(id);
    }

    @Override
    public Book save(Book book) {
        return super.save(book);
    }

    @Override
    public Book update(Book book) {
        return super.update(book);
    }

    @Override
    public void delete(Book book) {
        super.delete(book);
    }

    @Override
    public void deleteById(UUID id) {
        super.deleteById(id);
    }
}