package com.cn.hnny.entity;

import java.io.Serializable;
import java.util.List;

/**
 * tb_role
 * @author 
 */
public class Role implements Serializable {
    private String rid;

    private String rname;
    private String mid;

    private String mname;
    private int rstatus;
    private String type;
    private  List<Menu> listMenu;
    
    public int getRstatus() {
		return rstatus;
	}

	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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


    public List<Menu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
	}



	private static final long serialVersionUID = 1L;

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
}