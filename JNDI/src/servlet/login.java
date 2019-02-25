package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.serviceDao;
import service.serviceDaoImpl;

public class login extends HttpServlet{
	public static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String name=request.getParameter("user");
		String pa=request.getParameter("pa");//获取从前台传来的值
		if(name==""&&pa=="") {//进行判断
			response.sendRedirect("login.jsp");
		}else {
			User user =new User(name,pa);
			serviceDao dao =new serviceDaoImpl();//实例化service层
			PrintWriter out =response.getWriter();//可以使用out方法
			response.setContentType("text/html; charset=UTF-8");//设置字符集
			boolean login=dao.login(user);//调用service方法
			if(login) {//判断
				response.sendRedirect("main.jsp");
			}else {
				response.sendRedirect("login.jsp");//重定向
			}
		}
	}
}
