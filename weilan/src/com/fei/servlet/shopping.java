package com.fei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.fei.pojo.Page;
import com.fei.pojo.books;
import com.fei.service.serviceImpl;
import com.fei.service.service;

public class shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service s= new serviceImpl();
	

			Page page =s.getShopping();
			request.getSession().setAttribute("pagee", page);
			//response.sendRedirect("shopping.jsp");
		
			String f=request.getParameter("dd");
			if(f!=null&&f!="") {
				Integer ff=Integer.valueOf(f);
				boolean gg=s.insertTwo(ff);
				boolean de=s.delete(ff);
				Page pag =s.getShopping();
				String jsonn=JSON.toJSONString(pag);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print(jsonn);
				out.flush();
				out.close();
			}
			
			//System.out.println(ff);
			
			//System.out.println(de);
			
			//response.sendRedirect("shopping.jsp");
		}
		
	}

