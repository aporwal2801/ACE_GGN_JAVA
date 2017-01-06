package com.domain;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		// saveData();
//		mergeUpdateExp();
		sessionMultipleObj();

	}

	private static void sessionMultipleObj() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		Book book = (Book) session.get(Book.class, 3);
		Book newbook = (Book) session.get(Book.class, 3);

		System.out.println(book == newbook);

		book.setPublication("modified1");
		session.update(newbook);
		System.out.println("REsult : " + book);

		session.getTransaction().commit();

	}

	private static void mergeUpdateExp() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();
		Book book = (Book) session.get(Book.class, 3);

		System.out.println("REsult : " + book);

		session.close();

		book.setPublication("modified");

		Session session1 = new Configuration().configure().buildSessionFactory().openSession();
		session1.beginTransaction();
		Book book1 = (Book) session1.get(Book.class, 3);
		// session1.update(book);
		session1.merge(book);

		session1.getTransaction().commit();
	}

	private static void saveData() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		session.beginTransaction();
		Book book = new Book();

		book.setIsbn(2);
		book.setPublication("DEF");
		book.setPubDate("13-FEB-2016");
		session.save(book);
		session.getTransaction().commit();
	}

}
