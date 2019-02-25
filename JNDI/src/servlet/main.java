package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Message;
import entity.page;
import service.serviceDao;
import service.serviceDaoImpl;

public class main extends HttpServlet{
	public static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String currentPage = request.getParameter("index");
		if(currentPage==null) {
			currentPage="1";
		}
		Integer str=Integer.valueOf(currentPage);
		String pageSize = request.getParameter("end");
		if(pageSize==null) {
			pageSize="5";
		}
		Integer str1=Integer.valueOf(pageSize);
		//System.out.println(str);
		serviceDao dao = new serviceDaoImpl();
			page me=dao.save(str,str1);
			String jsonObject = JSON.toJSONString(me);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(jsonObject);//´«Êä
			out.flush();//Ë¢ÐÂ
			out.close();//¹Ø±Õ
		}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		this.doGet(request, response);
	}
}
