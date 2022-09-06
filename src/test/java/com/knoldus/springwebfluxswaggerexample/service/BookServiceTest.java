package com.knoldus.springwebfluxswaggerexample.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.knoldus.springwebfluxswaggerexample.model.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookService.class})
@ExtendWith(SpringExtension.class)
class BookServiceTest {
    @Autowired
    private BookService bookService;

    /**
     * Method under test: {@link BookService#save(Book)}
     */
    @Test
    void testSave() {
        // TODO: Complete this test.

        bookService.save(new Book("47", "BhagwatKatha", "D454RP56"));
    }

    /**
     * Method under test: {@link BookService#save(Book)}
     */
    @Test
    void testSave3() {
        Book book = mock(Book.class);
        when(book.getId()).thenReturn("42");
        doNothing().when(book).setId((String) any());
        bookService.save(book);
        verify(book).getId();
        verify(book).setId((String) any());
    }

    /**
     * Method under test: {@link BookService#update(String, Book)}
     */
    @Test
    void testUpdate() {
        // TODO: Complete this test.

        bookService.update("42", new Book("42", "Name", "Isbn"));
    }

    /**
     * Method under test: {@link BookService#update(String, Book)}
     */
    @Test
    void testUpdate2() {
        assertThrows(IllegalArgumentException.class, () -> bookService.update("Id", new Book("42", "Name", "Isbn")));
    }

    /**
     * Method under test: {@link BookService#findById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() {
        // TODO: Complete this test.

        bookService.findById("42");
    }

    /**
     * Method under test: {@link BookService#findAll()}
     */
    @Test
    void testFindAll() {

        bookService.findAll();
    }

}

