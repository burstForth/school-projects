package com.cn.hnny.entity;

import java.io.Serializable;

public class New implements Serializable {
	 private String nid;
	 private String ntitle;
	 private String ncontent;
	 private String ntype;
	 private String nname;
	 private String uname;
	 private String create_time;
	 private int nstatus;

	    private static final long serialVersionUID = 1L;

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getNid() {
			return nid;
		}

		public void setNid(String nid) {
			this.nid = nid;
		}

		public String getNtitle() {
			return ntitle;
		}

		public void setNtitle(String ntitle) {
			this.ntitle = ntitle;
		}

		public String getNcontent() {
			return ncontent;
		}

		public void setNcontent(String ncontent) {
			this.ncontent = ncontent;
		}

		public String getNtype() {
			return ntype;
		}

		public void setNtype(String ntype) {
			this.ntype = ntype;
		}

		public String getNname() {
			return nname;
		}

		public void setNname(String nname) {
			this.nname = nname;
		}

		public String getCreate_time() {
			return create_time;
		}

		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		public int getNstatus() {
			return nstatus;
		}

		public void setNstatus(int nstatus) {
			this.nstatus = nstatus;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	    
}
