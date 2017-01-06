package com.sapient.book;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="BOOK")
public class Book {
	
	private Integer bookId;
	private String bookName;
	private Set<BookCategory> categories = new HashSet<BookCategory>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID", unique = true, nullable = false)
	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	@Column(name = "BOOK_NAME", unique = true, nullable = false, length = 20)
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "book_category", 
				joinColumns = @JoinColumn(name = "BOOK_ID"),
				inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	public Set<BookCategory> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<BookCategory> categories) {
		this.categories = categories;
	}
	
}
