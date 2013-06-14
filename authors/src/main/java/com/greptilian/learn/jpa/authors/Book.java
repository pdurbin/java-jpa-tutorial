package com.greptilian.learn.jpa.authors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    String title;
    String originalPublicationYear;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    public Book() {
    }

    Book(String title, String year) {
        this.title = title;
        this.originalPublicationYear = year;
    }

    Book(String title, String year, Publisher publisher) {
        this.title = title;
        this.originalPublicationYear = year;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalPublicationYear() {
        return originalPublicationYear;
    }

    public void setOriginalPublicationYear(String originalPublicationYear) {
        this.originalPublicationYear = originalPublicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
