package com.bookstoreapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Book entity.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Author author;

    private String description;

    private String genre;

    private String publicationDate;

    private String price;

    /**
     * Default constructor.
     */
    public Book() {
    }

    /**
     * Parameterized constructor.
     *
     * @param idValue book id
     * @param titleValue book title
     * @param authorValue author object
     * @param descriptionValue description
     * @param genreValue genre
     * @param publicationDateValue publication date
     * @param priceValue book price
     */
    public Book(
            final Long idValue,
            final String titleValue,
            final Author authorValue,
            final String descriptionValue,
            final String genreValue,
            final String publicationDateValue,
            final String priceValue) {

        this.id = idValue;
        this.title = titleValue;
        this.author = authorValue;
        this.description = descriptionValue;
        this.genre = genreValue;
        this.publicationDate = publicationDateValue;
        this.price = priceValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long idValue) {
        this.id = idValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String titleValue) {
        this.title = titleValue;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(final Author authorValue) {
        this.author = authorValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            final String descriptionValue) {

        this.description = descriptionValue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genreValue) {
        this.genre = genreValue;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(
            final String publicationDateValue) {

        this.publicationDate = publicationDateValue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(final String priceValue) {
        this.price = priceValue;
    }
}