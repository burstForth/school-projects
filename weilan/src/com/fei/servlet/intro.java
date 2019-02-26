package com.fei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.pojo.Page;
import com.fei.pojo.books;
import com.fei.service.serviceImpl;
import com.fei.service.service;

public class intro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ii=request.getParameter("id");
		service s= new serviceImpl();
		if(ii!=null&& ii!="") {
			Integer i=Integer.valueOf(ii);
			List<books> intro=s.getIntro(i);
			request.getSession().setAttribute("intro", intro);
		}else{
			String iii=request.getParameter("idd");
			Integer dd=Integer.valueOf(iii);
			s.insertOne(dd);
		}
		response.sendRedirect("intro.jsp");
	}
}
