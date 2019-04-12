package com.cn.hnny.entity;

import java.io.Serializable;

public class Project extends PageUtil implements Serializable {
	 private String pid;

	    private String pname;

	    private String ptype;

	    private String pdescribe;
	    private String iid;//Í¼Æ¬Íâ¼ü
	    private String url;//Í¼Æ¬Ãû³Æ
	    private String ptid;//Íâ¼ü
	    private String pstatus;//ÉóºË±ê¼Ç
	    
	    public String getPstatus() {
			return pstatus;
		}

		public void setPstatus(String pstatus) {
			this.pstatus = pstatus;
		}

		public String getPtid() {
			return ptid;
		}

		public void setPtid(String ptid) {
			this.ptid = ptid;
		}

		public String getIid() {
			return iid;
		}

		public void setIid(String iid) {
			this.iid = iid;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		private static final long serialVersionUID = 1L;

	    public String getPid() {
	        return pid;
	    }

	    public void setPid(String pid) {
	        this.pid = pid;
	    }

	    public String getPname() {
	        return pname;
	    }

	    public void setPname(String pname) {
	        this.pname = pname;
	    }

	    public String getPtype() {
	        return ptype;
	    }

	    public void setPtype(String ptype) {
	        this.ptype = ptype;
	    }

	    public String getPdescribe() {
	        return pdescribe;
	    }

	    public void setPdescribe(String pdescribe) {
	        this.pdescribe = pdescribe;
	    }

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	    
	}
