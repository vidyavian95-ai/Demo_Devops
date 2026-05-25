package com.bookstoreapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String address;

    private String phone;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL
    )
    private List<Book> books = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Author() {
    }

    /**
     * Parameterized constructor.
     *
     * @param idValue author id
     * @param nameValue author name
     * @param emailValue author email
     * @param addressValue author address
     * @param phoneValue author phone
     * @param booksValue author books
     */
    public Author(
            final Long idValue,
            final String nameValue,
            final String emailValue,
            final String addressValue,
            final String phoneValue,
            final List<Book> booksValue) {

        this.id = idValue;
        this.name = nameValue;
        this.email = emailValue;
        this.address = addressValue;
        this.phone = phoneValue;

        if (booksValue != null) {
            this.books = new ArrayList<>(booksValue);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long idValue) {
        this.id = idValue;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameValue) {
        this.name = nameValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String emailValue) {
        this.email = emailValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String addressValue) {
        this.address = addressValue;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phoneValue) {
        this.phone = phoneValue;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void setBooks(final List<Book> booksValue) {

        if (booksValue == null) {
            this.books = new ArrayList<>();
        } else {
            this.books = new ArrayList<>(booksValue);
        }
    }
}