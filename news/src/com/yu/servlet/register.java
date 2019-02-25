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

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		ServiceDao se=new serviceimpl();
		String name=request.getParameter("account");
		String password=request.getParameter("password");
		System.out.println(name);
		if(password==null||password=="") {
			Account user=new Account(name);
			boolean me=se.verification(user);
			System.out.println(me);
			if(me) {
				out.print(me);
				out.flush();
				out.close();
			}else {
					out.print(false);
					out.flush();
					out.close();
			}
		}else {
			Account user=new Account(name,password);
			boolean me=se.register(user);
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
}
