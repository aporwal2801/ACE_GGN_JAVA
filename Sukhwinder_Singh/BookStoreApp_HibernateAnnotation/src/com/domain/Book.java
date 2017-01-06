package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "ISBN_ID")
	int isbn;

	@Column(name = "PUB")
	String publication;

	@Column(name = "PUB_DATE")
	String pubDate;

	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_CAT", joinColumns = { 
	      @JoinColumn(name = "ISBN_ID",
	      nullable = false, updatable = false)
	   }, inverseJoinColumns = { 
	      @JoinColumn(name = "idcategory",
	      nullable = false, updatable = false)
	   }
	)
	List<BookCategory> bCat = new ArrayList<BookCategory>();

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public void setbCat(List<BookCategory> bCat) {
		this.bCat = bCat;
	}

	public List<BookCategory> getbCat() {
		return bCat;
	}

	public Book(String pub, String pDate) {
		this.publication = pub;
		this.pubDate = pDate;
	}

	@Override
	public String toString() {

		return this.isbn + " " + this.publication + " " + this.pubDate;
	}

}
