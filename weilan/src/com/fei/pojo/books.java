package com.fei.pojo;

import java.sql.Date;

public class books {
	private int id;
	private String book;//书名
	private String author;//作者
	private String press;//出版商
	private Date time;//出版时间
	private String intro;//详细介绍
	private Float price;//价钱
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "books [id=" + id + ", book=" + book + ", author=" + author + ", press=" + press + ", time=" + time
				+ ", intro=" + intro + ", price=" + price + "]";
	}
	
}
