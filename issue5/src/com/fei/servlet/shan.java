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


public class shan extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ÎÒÊÇÉ¾³ý");
		request.setCharacterEncoding("utf-8");
		   String t = request.getParameter("id");
		    Integer y = Integer.valueOf(t);
			 News nn = new News(y);
			 newsService dao=new newsServiceImpl();
			 boolean as = dao.shan(nn);
			 if(as){
				 request.getRequestDispatcher ("/fenye").forward( request, response );
				 //response.sendRedirect("/fenye");
			 }else{
				 System.out.print("É¾³ýÊ§°Ü");
			 }
	}

}
