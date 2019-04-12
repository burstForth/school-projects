package com.cn.hnny.entity;

import java.io.Serializable;

/**
 * tb_img
 * @author 
 */
public class Img implements Serializable {
    private String iid;

    private String url;

    private String type;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}