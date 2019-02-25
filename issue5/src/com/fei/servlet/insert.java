package com.fei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.daoa.newsService;
import com.fei.entity.News;
import com.fei.entity.User;
import com.fei.service.newsServiceImpl;


public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hah");
		//request.setCharacterEncoding("utf-8");
		String name = request.getParameter("qe");
		String sex = request.getParameter("qr");
		String zhu = request.getParameter("qw");
		
		News aa = new News(zhu,name,sex);
		newsService dao=new newsServiceImpl();
		boolean z = dao.zeng(aa);
		if(z){
			request.getRequestDispatcher("didi.jsp").forward(request, response);
			}else{
				response.sendRedirect("insert.jsp");
			}
	}

}
