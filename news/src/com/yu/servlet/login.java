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
import com.yu.service.ServiceDao;
import com.yu.service.serviceimpl;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		Account user=new Account(name,password);
		ServiceDao se=new serviceimpl();
		boolean me=se.login(user);
		if(me) {
			//String json=JSON.toJSONString(me);
			out.print(me);
			out.flush();
			out.close();
		}else {
			out.print(false);
			out.flush();
			out.close();
		}
	}

}
