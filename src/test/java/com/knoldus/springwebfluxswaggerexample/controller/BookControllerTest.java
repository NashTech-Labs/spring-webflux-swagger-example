package com.knoldus.springwebfluxswaggerexample.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.springwebfluxswaggerexample.model.Book;
import com.knoldus.springwebfluxswaggerexample.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#all()}
     */
    @Test
    void testAll() throws Exception {
        when(bookService.findAll()).thenReturn(DirectProcessor.create());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#create(Book)}
     */
    @Test
    void testCreate() throws Exception {
        when(bookService.findAll()).thenReturn(DirectProcessor.create());

        Book book = new Book();
        book.setId("42");
        book.setIsbn("Isbn");
        book.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#create(Book)}
     */
    @Test
    void testCreate2() throws Exception {
        when(bookService.findAll()).thenReturn(EmitterProcessor.create(3, true));

        Book book = new Book();
        book.setId("42");
        book.setIsbn("Isbn");
        book.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#create(Book)}
     */
    @Test
    void testCreate3() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitError(new Throwable());
        when(bookService.findAll()).thenReturn(createResult);

        Book book = new Book();
        book.setId("42");
        book.setIsbn("Isbn");
        book.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#create(Book)}
     */
    @Test
    void testCreate4() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitNext(new Book("42", "?", "?"));
        when(bookService.findAll()).thenReturn(createResult);

        Book book = new Book();
        book.setId("42");
        book.setIsbn("Isbn");
        book.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#update(String, Book)}
     */
    @Test
    void testUpdate() throws Exception {
        when(bookService.update((String) any(), (Book) any())).thenReturn((Mono<Book>) mock(Mono.class));

        Book book = new Book();
        book.setId("42");
        book.setIsbn("Isbn");
        book.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/book/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#get(String)}
     */
    @Test
    void testGet() throws Exception {
        when(bookService.findById((String) any())).thenReturn((Mono<Book>) mock(Mono.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/{id}", "42");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#get(String)}
     */
    @Test
    void testGet2() throws Exception {
        when(bookService.findAll()).thenReturn(DirectProcessor.create());
        when(bookService.findById((String) any())).thenReturn((Mono<Book>) mock(Mono.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#get(String)}
     */
    @Test
    void testGet3() throws Exception {
        when(bookService.findAll()).thenReturn(EmitterProcessor.create(3, true));
        when(bookService.findById((String) any())).thenReturn((Mono<Book>) mock(Mono.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#get(String)}
     */
    @Test
    void testGet4() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitError(new Throwable());
        when(bookService.findAll()).thenReturn(createResult);
        when(bookService.findById((String) any())).thenReturn((Mono<Book>) mock(Mono.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#get(String)}
     */
    @Test
    void testGet5() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitNext(new Book("42", "?", "?"));
        when(bookService.findAll()).thenReturn(createResult);
        when(bookService.findById((String) any())).thenReturn((Mono<Book>) mock(Mono.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#delete(String)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(bookService).delete((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/book/{id}", "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link BookController#delete(String)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(bookService).delete((String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/book/{id}", "42");
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController).build().perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link BookController#all()}
     */
    @Test
    void testAll2() throws Exception {
        when(bookService.findAll()).thenReturn(EmitterProcessor.create(3, true));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#all()}
     */
    @Test
    void testAll3() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitError(new Throwable());
        when(bookService.findAll()).thenReturn(createResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BookController#all()}
     */
    @Test
    void testAll4() throws Exception {
        EmitterProcessor<Book> createResult = EmitterProcessor.create(3, true);
        createResult.tryEmitNext(new Book("42", "?", "?"));
        when(bookService.findAll()).thenReturn(createResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

