package com.sapient.book;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class MainApp {

	private static final String PERSISTENCE_UNIT_NAME = "book_category";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = null;
		EntityTransaction transaction = null;
		Book book = null;
		BookCategory bookCategory = null;

		try {
			em = factory.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			System.out.println("Creating book object");

			book = new Book();
			book.setBookName("Java Book");
			bookCategory = new BookCategory("Programming");
			book.getCategories().add(bookCategory);

			System.out.println("Persisting book object");

			em.persist(book);

			System.out.println("committing book object");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		System.out.println("Done");
	}
}
