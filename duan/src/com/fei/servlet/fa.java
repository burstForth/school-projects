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


public class fa extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("你是谁");
	    //request.setCharacterEncoding("utf-8");
		String a = request.getParameter("select");
		String nei = request.getParameter("nei");
		String ui = request.getParameter("uid");
		//System.out.println(name);
		newsService ns = new newsServiceImpl();
			if(a==null&&nei==null) {
				String name=request.getParameter("id");
				Integer m = Integer.valueOf(name);
				//System.out.println(m);
				List<User> t=ns.hu(m);
				request.getSession().setAttribute("list", t);
				response.sendRedirect("fa.jsp");
					}else {
						Integer u = Integer.valueOf(a);
						Integer uid = Integer.valueOf(ui);
						du du = new du(nei,u,uid);
						boolean f=ns.ti(du);
						if(f) {
							
							System.out.println("添加成功");
							response.sendRedirect("fa.jsp");
						}
					}
			//弹框代码
			//PrintWriter out = response.getWriter();
			//out.print();才可以使用
		//List<User> t=ns.hu();
		//request.getSession().setAttribute("list", t);
				
	}

}
