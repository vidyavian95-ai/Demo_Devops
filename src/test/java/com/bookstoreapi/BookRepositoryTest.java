package com.bookstoreapi;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bookstoreapi.entity.Book;
import com.bookstoreapi.repository.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository repo;

    @Test
    void saveAndFind() {

        Book book = new Book(
            null,
            "Title",
            null,
            "Java Description",
            "Programming",
            "2025",
            "500");
        Book saved = repo.save(book);

        var found = repo.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Title");
    }
}