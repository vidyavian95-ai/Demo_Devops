package com.bookstoreapi.controller;

import com.bookstoreapi.entity.Book;
import com.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book saveBook = bookService.createBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId){
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>>getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

 /**
 * Updates book details.
 *
 * @param bookId book id
 * @param book updated book object
 * @return updated book response
 */
@PutMapping("{id}")
public ResponseEntity<Book> updateBook(
        @PathVariable("id") final Long bookId,
        @RequestBody final Book book) {

    book.setId(bookId);

    Book updatedBook =
            bookService.updateBook(book);

    return new ResponseEntity<>(
            updatedBook,
            HttpStatus.OK);
}

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book was deleted succssfully", HttpStatus.OK);
    }
    @PostMapping("/bulk")
    public ResponseEntity<List<Book>> createBooks(@RequestBody List<Book> book) {
        List<Book> savedBooks = bookService.createBooks(book);
        return new ResponseEntity<>(savedBooks, HttpStatus.CREATED);
    }
}
