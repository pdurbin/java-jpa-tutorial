package com.greptilian.learn.jpa.authors;

import java.util.ArrayList;
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

        Author author1 = new Author();
        author1.setName("Ernest Hemingway");

        Book book1 = new Book();
        book1.setTitle("The Sun Also Rises");
        book1.setOriginalPublicationYear("1926");
        Publisher book1publisher = new Publisher();
        book1publisher.setName("Scribner");
        em.persist(book1publisher);
        book1.setPublisher(book1publisher);
        em.persist(book1);

        Book book2 = new Book();
        book2.setTitle("A Farewell to Arms");
        book2.setOriginalPublicationYear("1929");
        Publisher book2publisher = new Publisher();
        book2publisher.setName("Scribner");
        em.persist(book2publisher);
        book2.setPublisher(book2publisher);
        em.persist(book2);

        List<Book> author1booklist = new ArrayList<Book>();
        author1booklist.add(book1);
        author1booklist.add(book2);
        author1.setBooks(author1booklist);

        em.persist(author1);

        em.getTransaction().commit();

        Query query = em.createQuery("SELECT author FROM Author author");
        List<Author> authors = query.getResultList();
        for (Author author : authors) {
            List<Book> books = author.getBooks();
            for (Book book : books) {
                System.out.println("\"" + book.getTitle() + "\" by " + author.getName() + " (" + book.getPublisher().getName() + ", " + book.getOriginalPublicationYear() + ")");
            }
        }

    }
}
