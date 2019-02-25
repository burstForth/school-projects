package com.fei.entity;

public class du {
		private int fid;
		private String nei;
		private int id;
		private int uid;
		public du(int fid, String nei) {
			super();
			this.fid = fid;
			this.nei = nei;
		}
		public du(String nei,int id,int uid) {
			this.nei=nei;
			this.id =id;
			this.uid =uid;
		}
		public du() {
					
				}
		public du(int id) {
			
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public String getNei() {
			return nei;
		}
		public void setNei(String nei) {
			this.nei = nei;
		}
	
		public String toString() {
			return nei;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		
}
