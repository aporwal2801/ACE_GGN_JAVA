package com.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
	
		m2m_Test();
	}

	private static void m2m_Test() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		
		Book b1 = new Book("p1", "12-JAN");
//		Book b2 = new Book("p2", "13-JAN");
		
		BookCategory bcat1 = new BookCategory("Math");
		BookCategory bcat2 = new BookCategory("Science");
		
		List<BookCategory> cList = new ArrayList<BookCategory>();
		cList.add(bcat1);cList.add(bcat2);
		
		b1.setbCat(cList);
		
		session.save(b1);
		session.getTransaction().commit();
	}

}
