package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class BookCategory {

	@Id
	@GeneratedValue
	@Column(name="idcategory")
	int cID;
	@Column(name="cat_name")
	String cName;
	
	@ManyToMany(mappedBy ="bCat")
	List<Book> books = new ArrayList<Book>();
	
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	public BookCategory(String name) {
		this.cName=name;
	}
	
	}
