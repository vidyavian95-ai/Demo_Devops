package com.bookstoreapi.implementation;

import com.bookstoreapi.entity.Book;
import com.bookstoreapi.repository.BookRepository;
import com.bookstoreapi.service.BookService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Book service implementation.
 */
@Service
public class BookImplementation implements BookService {

    /**
     * Book repository.
     */
    private final BookRepository bookRepository;

    /**
     * Constructor injection.
     *
     * @param bookRepositoryValue repository object
     */
    public BookImplementation(
            final BookRepository bookRepositoryValue) {

        this.bookRepository = bookRepositoryValue;
    }

    /**
     * Creates a new book.
     *
     * @param book book object
     * @return saved book
     */
    @Override
    public Book createBook(final Book book) {

        return bookRepository.save(book);
    }

    /**
     * Creates multiple books.
     *
     * @param books list of books
     * @return saved books
     */
    @Override
    public List<Book> createBooks(final List<Book> books) {

        return bookRepository.saveAll(books);
    }

    /**
     * Gets book by id.
     *
     * @param bookId book id
     * @return found book
     */
    @Override
    public Book getBookById(final Long bookId) {

        Optional<Book> optionalBook =
                bookRepository.findById(bookId);

        return optionalBook.orElse(null);
    }

    /**
     * Gets all books.
     *
     * @return list of books
     */
    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    /**
     * Updates existing book.
     *
     * @param book updated book
     * @return updated entity
     */
    @Override
    public Book updateBook(final Book book) {

        Optional<Book> optionalBook =
                bookRepository.findById(book.getId());

        if (optionalBook.isEmpty()) {
            return null;
        }

        Book existingBook = optionalBook.get();

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(
                book.getDescription());
        existingBook.setGenre(book.getGenre());

        existingBook.setPublicationDate(
                book.getPublicationDate());

        return bookRepository.save(existingBook);
    }

    /**
     * Deletes book by id.
     *
     * @param bookId book id
     */
    @Override
    public void deleteBook(final Long bookId) {

        bookRepository.deleteById(bookId);
    }

    /**
     * Gets books by author id.
     *
     * @param authId author id
     * @return list of books
     */
    @Override
    public List<Book> getAllBooksByAuthId(
            final Long authId) {

        return List.of();
    }
}