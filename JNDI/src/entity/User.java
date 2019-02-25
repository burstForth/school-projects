package entity;

public class User {
	private int uid;
	private String user;
	private String pass;
	
	public User() {
		super();
	}
	public User(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString() {
		return "User [uid=" + uid + ", user=" + user + ", pass=" + pass + "]";
	}
	
}
