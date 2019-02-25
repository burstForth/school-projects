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
import com.fei.entity.du;
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
		String name = request.getParameter("name"); 
		//System.out.println(name);
		request.getSession().setAttribute("uname", name);
		String id=request.getParameter("id");
		String nei=request.getParameter("nei");
		Integer s = Integer.valueOf(id);
		String iid=request.getParameter("iid");
		Integer k = Integer.valueOf(iid);
		du du=new du(nei,s,k);
		newsService dao=new newsServiceImpl();
		boolean v=dao.ti(du);
		if(v){
			//response.sendRedirect("/fenye");
			request.getRequestDispatcher("/fenye").forward(request, response);
			}else{
				response.sendRedirect("huifu.jsp");
			}
	}

}
