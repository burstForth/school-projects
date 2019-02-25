package com.fei.entity;

public class shangchuan {
	private  int sid;
	private  String name;
	private  String file;
	private  String adress;
	
	public shangchuan(String name,String file, String adress) {
		this.name = name;
		this.adress = adress;
		this.file = file;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}

	
}
