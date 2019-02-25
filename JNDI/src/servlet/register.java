package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Message;
import entity.User;
import service.serviceDao;
import service.serviceDaoImpl;

public class register extends HttpServlet{
	public static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		serviceDao dao = new serviceDaoImpl();
		if(pass==null) {
			boolean me =dao.verification(name);
			boolean used=false;
				if(me) {//еп╤о
					used=true;
				}else{
					used=false;
				}
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print(used);
				out.flush();
				out.close();
		}else{
			boolean register =dao.register(name,pass);
			if(register) {
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("register.jsp");
			}
		}
		}
		
		
		
		
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		this.doGet(request, response);
	}
}
