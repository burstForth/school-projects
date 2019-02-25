package com.yu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yu.jopo.Account;
import com.yu.jopo.Content;
import com.yu.service.ServiceDao;
import com.yu.service.serviceimpl;

public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		ServiceDao se=new serviceimpl();
		String sid=request.getParameter("sid");
		boolean nee=false;
		if(sid!=null&&sid!=""){
			Integer ssid=Integer.valueOf(sid);
			boolean rt=se.delete(ssid);
			if(rt) {
				nee=true;
			}
		}else{
			String id=request.getParameter("cid");
			Integer cid=Integer.valueOf(id);
			boolean uup=se.deleteone(cid);
			if(uup) {
				nee=true;
			}
		}
		out.println(nee);
		out.flush();
		out.close();
	}
}
