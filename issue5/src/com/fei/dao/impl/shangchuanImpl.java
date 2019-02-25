package com.fei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fei.daoa.shangchuanDao;
import com.fei.entity.shangchuan;
import com.fei.util.DatabaseUtil;

public class shangchuanImpl implements shangchuanDao{
	private Connection conn = null;
	private PreparedStatement par=null;
	private ResultSet rs = null;
	DatabaseUtil db = new DatabaseUtil();
	
	public shangchuanDao tiqu() {
		
		return null;
	}


	public boolean bao(shangchuan shang) {
		boolean flog = false;
		conn = db.getConnection();
		String sql = "insert into wen (name,file,adress) values (?,?,?)";
		try {
			par = conn.prepareStatement(sql);
			par.setString(1,shang.getName());
			par.setString(2,shang.getFile());
			par.setString(3,shang.getAdress());
			int i = par.executeUpdate();
			if(i>0) {
				flog = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(rs, par, conn);
		}
		return flog;
	}

}
