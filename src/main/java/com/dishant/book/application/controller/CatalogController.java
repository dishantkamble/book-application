package com.dishant.book.application.controller;

import java.util.UUID;

import com.dishant.book.application.service.CatalogService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dishant.book.application.model.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags = { "catalog" })
@AllArgsConstructor
@RestController
@RequestMapping("catalog")
public class CatalogController {

  private CatalogService catalogService;

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @ApiOperation(value = "Save book", nickname = "saveBook")
  public void saveBook(@RequestBody Book book) {
    this.catalogService.saveBook(book);
  }

  @PutMapping(path = "/{id}")
  @ApiOperation(value = "Update book", nickname = "updateBook")
  public Book updateBook(@PathVariable String id, @RequestBody Book book) {
    return this.catalogService.updateBook(book);
  }

  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @ApiOperation(value = "Delete book by Id", nickname = "deleteBookById")
  public void deleteBookById(@PathVariable String id) {
    this.catalogService.deleteBookById(UUID.fromString(id));
  }

  @PutMapping(path = "/{id}/sell")
  @ApiOperation(value = "Sell books", nickname = "sellBooks")
  public Book sellBooks(@PathVariable String id, @RequestParam Long quantityToSell, @RequestBody Book book) {
    return this.catalogService.sellBooks(book, quantityToSell);
  }

  @PutMapping(path = "/{id}/add-stock")
  @ApiOperation(value = "Add Stock for a Book", nickname = "addStock")
  public Book addStock(@PathVariable String id, @RequestParam Long stockToAdd, @RequestBody Book book) {
    return this.catalogService.addStock(book, stockToAdd);
  }
}