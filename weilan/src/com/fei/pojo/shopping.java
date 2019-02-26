package com.fei.pojo;

public class shopping {
	private int id;
	private String book;// È√˚
	private Float price;//º€«Æ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "shopping [id=" + id + ", book=" + book + ", price=" + price + "]";
	}
	
}
