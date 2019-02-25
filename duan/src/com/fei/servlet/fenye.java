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
import com.fei.entity.Page;
import com.fei.entity.User;
import com.fei.entity.du;
import com.fei.service.newsServiceImpl;


public class fenye extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("fenye");
		
		String name = request.getParameter("uname");
		//String nam = request.getParameter("name");
		//System.out.println(name);
		//String pass = request.getParameter("upwd");
		
		String str =request.getParameter("index");	
		if(str==null){
			str="1";
		}
		Integer currPage =Integer.parseInt(str);
		if(currPage==0){
			currPage=1;
		}
		//out.print(currPage);
		String str1 =request.getParameter("pageSize");	
		if(str1==null){
			str1="10";
		}
		Integer pageSize =Integer.parseInt(str1);
		if(name==null) {
			
			String nam = request.getSession().getAttribute("name").toString();
			User oo=new User(nam);
			newsService ns = new newsServiceImpl();
			User sf= ns.huo(oo);
			
			System.out.println(sf.getUser());
			request.getSession().setAttribute("sf", sf);
			System.out.println(sf.getId());
			int l=sf.getId();
			Page p = ns.huo(l,currPage, pageSize);
			//System.out.println(l);
			du k=new du(l);
			List<du> du =ns.huo1(k);
			List<du> ne=p.getNewsList();
			request.getSession().setAttribute("lis", ne);
			request.getSession().setAttribute("du", du);
			request.getSession().setAttribute("name", nam);
			response.sendRedirect("didi.jsp");
		}else {
		User oo=new User(name);
		newsService ns = new newsServiceImpl();
		User sf= ns.huo(oo);
		//System.out.println(sf.getId());
		//System.out.println(sf.getUser());
		request.getSession().setAttribute("sf", sf);
		int l=sf.getId();
		//System.out.println(l);
		du k=new du(l);
		List<du> du =ns.huo1(k);
		request.getSession().setAttribute("du", du);
		/*User t = new User(uname);
		
		List<du> sf= ns.huo(t);*/
		//request.getSession().setAttribute("sf", sf);
		Page p = ns.huo(l,currPage, pageSize);
		List<du> ne=p.getNewsList();
		request.getSession().setAttribute("lis", ne);
		request.getSession().setAttribute("page", p);
		request.getSession().setAttribute("name", name);
		//session.setAttribute("page", p);
		response.sendRedirect("didi.jsp");
		}
	}
}
