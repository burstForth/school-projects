package com.cn.hnny.entity;

import java.io.Serializable;

/**
 * tb_user_role
 * @author 
 */
public class UserRole implements Serializable {
    private String urid;

    private String uid;

    private String rid;

    private static final long serialVersionUID = 1L;

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}