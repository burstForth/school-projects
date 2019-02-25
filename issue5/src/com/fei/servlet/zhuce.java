package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.dao.impl.UserDaoImpl;
import com.fei.daoa.newsService;
import com.fei.daoa.userDao;
import com.fei.entity.News;
import com.fei.entity.User;
import com.fei.service.newsServiceImpl;


public class zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hehe");
		  String name = request.getParameter("name");
	        String result = null;
	        if("123".equals(name)){
	            result = "fail";
	        }else{
	            result = "success";
	        }
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        out.flush();
	}
		//request.setCharacterEncoding("utf-8");
		/*String name = request.getParameter("qe");
		String pass = request.getParameter("qr");
		if(name=="" || pass=="") {
			System.out.println("不能为空");
			response.sendRedirect("register.jsp");
		}else {
		User q = new User(name,pass);
		newsService dao=new newsServiceImpl();
			boolean a = dao.yan(q);
			if(a){
				System.out.println("该用户已注册");
				response.sendRedirect("register.jsp");
			}else {
				boolean z = dao.zhu(q);
				if(z) {
					response.sendRedirect("login.jsp");
				}
				else{
					response.sendRedirect("register.jsp");
				}
			}
		}

}*/
	}
