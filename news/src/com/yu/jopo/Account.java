package com.yu.jopo;

public class Account {
	private int aid;
	private String accountNumber;
	private String password;
	
	public Account() {
		super();
	}
	public Account(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	public Account(String accountNumber,String password) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Account [aid=" + aid + ", accountNumber=" + accountNumber + ", password=" + password + "]";
	}
	
}
