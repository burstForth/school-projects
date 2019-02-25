package com.yu.jopo;

public class pageList {
	private int cid;//内容id
	private int s_sid;//主题id
	private String news;//新闻
	private String author;//作者
	private int sid;
	private String topic;
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String toString() {
		return "pageList [cid=" + cid + ", s_sid=" + s_sid + ", news=" + news + ", author=" + author + ", sid=" + sid
				+ ", topic=" + topic + "]";
	}
	
}
