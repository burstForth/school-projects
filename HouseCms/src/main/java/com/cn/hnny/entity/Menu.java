package com.cn.hnny.entity;

import java.io.Serializable;

/**
 * tb_menu
 * @author 
 */
public class Menu implements Serializable {
    private String mid;

    private String mname;

    private String url;

    private String type;

    private String parene_id;

    private String code;

    private Integer orderby;
   private String mstatus;


	public String getMstatus() {
	return mstatus;
}

public void setMstatus(String mstatus) {
	this.mstatus = mstatus;
}

	private static final long serialVersionUID = 1L;

    public String getMid() {
        return mid;
    }

    public void setMd(String mid) {
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

	public void setMid(String mid) {
		this.mid = mid;
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