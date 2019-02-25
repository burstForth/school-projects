package com.yu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yu.jopo.Account;
import com.yu.jopo.Content;
import com.yu.service.ServiceDao;
import com.yu.service.serviceimpl;

public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		ServiceDao se=new serviceimpl();
		String sid=request.getParameter("sid");
		Integer ssid=Integer.valueOf(sid);
		String topic=request.getParameter("topic");
		boolean nee=false;
		if(topic!=null&&topic!="") {
			boolean up=se.update(ssid,topic);
			if(up) {
				nee=true;
			}
		}else{
			System.out.println("º”»Î");
			String newss=request.getParameter("news");
			String authorr=request.getParameter("author");
			String id=request.getParameter("cid");
			Integer cid=Integer.valueOf(id);
			boolean uup=se.updateone(ssid,cid,newss,authorr);
			if(uup) {
				nee=true;
			}
		}
		out.println(nee);
		out.flush();
		out.close();
	}
}
