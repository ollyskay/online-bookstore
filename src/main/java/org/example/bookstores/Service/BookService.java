package org.example.bookstores.Service;

import org.example.bookstores.Model.Book;
import org.example.bookstores.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBook(Long id, Book updatedbook){
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedbook.getTitle());
                    book.setAuthor(updatedbook.getAuthor());
                    book.setPrice(updatedbook.getPrice());
                    book.setAvailable(updatedbook.isAvailable());
                    return bookRepository.save(book);
                }).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }



}
