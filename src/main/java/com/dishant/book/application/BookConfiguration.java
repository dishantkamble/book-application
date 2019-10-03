package com.dishant.book.application;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dishant.book.application.model.Author;
import com.dishant.book.application.model.Book;
import com.dishant.book.application.model.Country;
import com.dishant.book.application.model.Genre;
import com.dishant.book.application.model.LocalPrice;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BookConfiguration {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dishant.book.application.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Book Application")
                .version("1.0.0-SNAPSHOT")
                .contact(new Contact("Dishant Kamble", "", "dishantk@gmail.com"))
                .description("Provides Public API endpoint documentation for - Book Application")
                .build();
    }

    @Bean
    public Map<UUID, Book> bookPersistence() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Map<UUID, Author> authorPersistence() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Map<UUID, LocalPrice> localPricePersistence() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    InitializingBean bookInitializingBean(Map<UUID, Book> bookPersistence, Map<UUID, Author> authorPersistence,
            Map<UUID, LocalPrice> localPricePersistence) {
        return () -> {
            LocalPrice price = LocalPrice.builder()
                    .country(Country.INDIA)
                    .price(new BigDecimal(200))
                    .build();
            price.setId(UUID.randomUUID());
            localPricePersistence.put(price.getId(), price);

            Author author = Author.builder()
                    .name("R K Narayanan")
                    .country(Country.INDIA)
                    .activeFrom(Year.of(2000))
                    .activeTo(Year.of(2019))
                    .build();
            author.setId(UUID.randomUUID());
            authorPersistence.put(author.getId(), author);

            Book book = Book.builder()
                    .title("First Book")
                    .author(author)
                    .genre(Genre.BIOGRAPHY)
                    .publishedOn(Year.of(2000))
                    .price(price)
                    .build();
            book.setId(UUID.randomUUID());
            bookPersistence.put(book.getId(), book);
        };
    }
}