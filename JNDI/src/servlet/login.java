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
		String pa=request.getParameter("pa");//��ȡ��ǰ̨������ֵ
		if(name==""&&pa=="") {//�����ж�
			response.sendRedirect("login.jsp");
		}else {
			User user =new User(name,pa);
			serviceDao dao =new serviceDaoImpl();//ʵ����service��
			PrintWriter out =response.getWriter();//����ʹ��out����
			response.setContentType("text/html; charset=UTF-8");//�����ַ���
			boolean login=dao.login(user);//����service����
			if(login) {//�ж�
				response.sendRedirect("main.jsp");
			}else {
				response.sendRedirect("login.jsp");//�ض���
			}
		}
	}
}
