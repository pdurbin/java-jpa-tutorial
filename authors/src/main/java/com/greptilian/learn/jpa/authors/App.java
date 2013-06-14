package com.greptilian.learn.jpa.authors;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {

    public static void main(String[] args) {
        System.out.println("JPA tutorial example using derby memory...");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("authorsDatabase");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Author author1 = new Author("Ernest Hemingway");
        Publisher scribner = new Publisher("Scribner");
        Book author1book1 = new Book("The Sun Also Rises", "1926", scribner);
        Book author1book2 = new Book("A Farewell to Arms", "1929", scribner);
        author1.setBooks(Arrays.asList(author1book1, author1book2));
        em.persist(author1);

        Author author2 = new Author("James Joyce");
        author2.setBooks(Arrays.asList(new Book("Ulysses", "1922", new Publisher("Sylvia Beach"))));
        em.persist(author2);

        em.getTransaction().commit();

        Query authorQuery = em.createQuery("SELECT author FROM Author author");
        List<Author> authors = authorQuery.getResultList();
        for (Author author : authors) {
            for (Book book : author.getBooks()) {
                System.out.println(author.getName() + " wrote \"" + book.getTitle() + "\" in " + book.getOriginalPublicationYear() + " (" + book.getPublisher().getName() + ")");
            }
        }

        Query bookQuery = em.createQuery("SELECT book from Book book");
        List<Book> books = bookQuery.getResultList();
        for (Book book : books) {
            System.out.println("\"" + book.getTitle() + "\" (" + book.getPublisher().getName() + ", " + book.getOriginalPublicationYear() + ")");
        }

        Query publisherQuery = em.createQuery("SELECT pub FROM Publisher pub");
        List<Publisher> pubs = publisherQuery.getResultList();
        for (Publisher publisher : pubs) {
            System.out.println("publisher: " + publisher.getName());
        }

    }
}
