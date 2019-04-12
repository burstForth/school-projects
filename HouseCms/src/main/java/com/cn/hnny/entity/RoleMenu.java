package com.cn.hnny.entity;

import java.io.Serializable;

/**
 * tb_role_menu
 * @author 
 */
public class RoleMenu implements Serializable {
    private String rmid;

    private String rid;

    private String mid;

    private static final long serialVersionUID = 1L;

    public String getRmid() {
        return rmid;
    }

    public void setRmid(String rmid) {
        this.rmid = rmid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}