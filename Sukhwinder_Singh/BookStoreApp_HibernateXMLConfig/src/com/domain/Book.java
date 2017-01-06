package com.domain;

public class Book {

	int isbn;
	String publication;
	String pubDate;

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
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}public String getPubDate() {
		return pubDate;
	}
	
	@Override
	public String toString() {
	
		return this.isbn +" "+ this.publication +" "+ this.pubDate;
	}
	
}
