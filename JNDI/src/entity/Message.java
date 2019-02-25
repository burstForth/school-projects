package entity;

public class Message {
	private int mid;
	private String nei;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getNei() {
		return nei;
	}
	public void setNei(String nei) {
		this.nei = nei;
	}
	public String toString() {
		return "Message [mid=" + mid + ", nei=" + nei + "]";
	}
	
	
}
