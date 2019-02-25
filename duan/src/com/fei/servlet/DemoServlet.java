package com.fei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.daoa.newsService;
import com.fei.entity.User;
import com.fei.entity.du;
import com.fei.service.newsServiceImpl;


public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hah");
		//request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pass = request.getParameter("upwd");
		if(name=="" || pass=="") {
			System.out.println("yong");
			response.sendRedirect("login.jsp");
		}else {
			User uu = new User(name,pass);
			newsService dao=new newsServiceImpl();
			//调用dao层实现类的注册方法并返回结果
			boolean as = dao.deng(uu);
			if(as){
			     request.getRequestDispatcher ("/fenye").forward( request, response );
				}else {
					response.sendRedirect("login.jsp");
					System.out.println("zdjbz");
				}
		}
		
	}

}
