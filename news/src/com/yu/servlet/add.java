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

public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		ServiceDao se=new serviceimpl();
		String name=request.getParameter("name");
		boolean nee=false;
		if(name!=null&&name!="") {
			boolean ne=se.insert(name);
			if(ne) {
				nee=true;
			}
		}else {
			String topic=request.getParameter("topic");
			Integer to=Integer.valueOf(topic);
			String news=request.getParameter("news");
			String author=request.getParameter("author");
			Content co=new Content(to,news,author);
			boolean me=se.insertone(co);
			if(me) {
				nee=true;
			}
		}
		out.println(nee);
		out.flush();
		out.close();
	}
}
