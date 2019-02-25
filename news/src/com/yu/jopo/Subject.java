package com.yu.jopo;

public class Subject {
	private int sid;
	private String topic;
	
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
		return "sid=" + sid + ", topic=" + topic;
	}
	
}
