package com.cn.hnny.vo;

import com.cn.hnny.entity.PageUtil;

public class UserRoleMenuVo  extends PageUtil {
	    private String uid;

	    private String uname;

	    private String upwd;
	    
	    private String rid;

	    private String rname;
	    
	    private String mid;

	    private String mname;

	    private String url;

	    private String type;

	    private String parene_id;

	    private String code;

	    private Integer orderby;
	    private String phone;
	    
        public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		private String create_time;
        
		public String getCreate_time() {
			return create_time;
		}

		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getUpwd() {
			return upwd;
		}

		public void setUpwd(String upwd) {
			this.upwd = upwd;
		}

		public String getRid() {
			return rid;
		}

		public void setRid(String rid) {
			this.rid = rid;
		}

		public String getRname() {
			return rname;
		}

		public void setRname(String rname) {
			this.rname = rname;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getMname() {
			return mname;
		}

		public void setMname(String mname) {
			this.mname = mname;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		
		public String getParene_id() {
			return parene_id;
		}

		public void setParene_id(String parene_id) {
			this.parene_id = parene_id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Integer getOrderby() {
			return orderby;
		}

		public void setOrderby(Integer orderby) {
			this.orderby = orderby;
		}
	 
}
