package com.knoldus.springwebfluxswaggerexample.service;

import com.knoldus.springwebfluxswaggerexample.model.Book;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Temporal in-memory implementation of book service.
 */
@Service
public class BookService {

    private final Map<String, Book> bookRepository;

    public BookService() {
        bookRepository = new ConcurrentHashMap<>();
    }

    public Mono<Book> save(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookRepository.put(book.getId(), book);
        return Mono.just(book);
    }

    public Mono<Book> update(String id, Book book) {
        if (!bookRepository.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        bookRepository.put(id, book);
        return Mono.just(book);
    }

    public Mono<Book> findById(String id) {
        return Mono.just(bookRepository.get(id));
    }

    public Flux<Book> findAll() {
        return Flux.fromIterable(bookRepository.values());
    }

    public void delete(String id) {
        Book removed = bookRepository.remove(id);
        Mono.just(removed);
    }
}
