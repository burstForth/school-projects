package com.yu.jopo;

public class Content {
	private int cid;//内容id
	private int s_sid;//主题id
	private String news;//新闻
	private String author;//作者
	
	
	public Content(int s_sid, String news, String author) {
		this.s_sid = s_sid;
		this.news = news;
		this.author = author;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getS_sid() {
		return s_sid;
	}
	public void setS_sid(int s_sid) {
		this.s_sid = s_sid;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String toString() {
		return "cid=" + cid + ", s_sid=" + s_sid + ", news=" + news + ", author=" + author;
	}
}
