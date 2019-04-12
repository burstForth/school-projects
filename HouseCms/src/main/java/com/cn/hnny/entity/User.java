package com.cn.hnny.entity;

import java.io.Serializable;
import java.util.List;

/**
 * tb_user
 * @author 
 */
public class User implements Serializable {
    private String uid;

    private String uname;

    private String upwd;

    private String phone;

    private String create_time;
    
    private int ustatus;
    private  List<Role> listrole;
    private String rid;

    private String rname;

	public int getUstatus() {
		return ustatus;
	}

	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
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

	public List<Role> getListrole() {
		return listrole;
	}

	public void setListrole(List<Role> listrole) {
		this.listrole = listrole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

  
}