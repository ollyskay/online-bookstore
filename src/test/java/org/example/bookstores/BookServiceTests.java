package org.example.bookstores;

import org.example.bookstores.Model.Book;
import org.example.bookstores.Repository.BookRepository;
import org.example.bookstores.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setTitle("Sample Book");
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.addBook(book));
    }
}
