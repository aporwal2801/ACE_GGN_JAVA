package com.sapient.book;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="BOOKCATEGORY")
public class BookCategory {
	
	private Integer categoryId;
	private String categoryName;
	private Set<Book> books = new HashSet<Book>(0);
	
	public BookCategory(String string) {
		this.categoryName = categoryName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "CATEGORY_NAME", nullable = false, length = 10)
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@ManyToMany(
			mappedBy = "categories",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public Set<Book> getBooks() {
		return books;
	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
}
