package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.serviceDao;
import service.serviceDaoImpl;

public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceDao dao=new serviceDaoImpl();
		boolean delete=dao.delete();
		if(delete) {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.print(delete);
			out.flush();
			out.close();
		}else {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			out.print("");
			out.flush();
			out.close();
		}
	}

}
