
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


public class cha extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hehe");
		//System.out.println(name);
		//String de=new String(request.getParameter("nei").getBytes("iso8859_1"),"utf-8");
		//de = java.net.URLDecoder.decode(de, "utf-8");
		String de=request.getParameter("id");
		Integer der = Integer.valueOf(de);
		String er=request.getParameter("iid");
		Integer ere = Integer.valueOf(er);
		newsService dao=new newsServiceImpl();
		//String name = request.getParameter("name");
		//du me=dao.huo(der);
		//request.getSession().setAttribute("me",me);
		//int ve=me.getId();
		//System.out.println(ve);
		//User sf= dao.huo(oo);
		User ne =dao.hui(der);
		//request.setAttribute("sf", sf);
		//List<News> list=dao.cha();
		request.getSession().setAttribute("ue",ne);
		request.getSession().setAttribute("ere",ere);
		//System.out.println(ne.getUser());
		//request.getRequestDispatcher("huifu.jsp").forward(request,response);	
		response.sendRedirect("huifu.jsp");
	}

}
