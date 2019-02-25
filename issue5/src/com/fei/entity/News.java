package com.fei.entity;

public class News {
	private int nid;
	private String nei;
	private String per;
	private  String sex;
	
	
	
	public News(String nei, String per, String sex) {
		super();
		this.nei = nei;
		this.per = per;
		this.sex = sex;
	}
	public News(int nid) {
		super();
		this.nid = nid;
	}
	public News( String nei,int nid) {
		
		this.nid = nid;
		this.nei = nei;
	}
	public News() {
		super();
	}
	public News(String nei) {
		super();
		this.nei = nei;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNei() {
		return nei;
	}
	public void setNei(String nei) {
		this.nei = nei;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return  per+""+sex+nei ;
	}

	
	
	
	
}
