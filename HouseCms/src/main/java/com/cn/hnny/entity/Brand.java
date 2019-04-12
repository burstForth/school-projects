package com.cn.hnny.entity;

import java.io.Serializable;

public class Brand extends PageUtil implements Serializable{
	private String bid;

    private String btitle;

    private String bname;

    private String uname;

    private String create_time;

    private Integer bstatus;

    private String bcontent;

    private static final long serialVersionUID = 1L;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getBstatus() {
        return bstatus;
    }

    public void setBstatus(Integer bstatus) {
        this.bstatus = bstatus;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
}
