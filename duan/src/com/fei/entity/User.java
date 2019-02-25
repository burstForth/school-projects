package com.fei.entity;

public class User {
private int uid;
private  String user;
private  String upass;
private  int id;


public User() {
	
}
public User(int id) {
	this.id=id;
}
public User(String user) {
	super();
	this.user = user;
}
public User(String user, String upass) {
	super();
	this.user = user;
	this.upass = upass;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getUpass() {
	return upass;
}
public void setUpass(String upass) {
	this.upass = upass;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



}
