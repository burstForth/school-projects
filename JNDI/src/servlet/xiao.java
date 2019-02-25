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
import service.serviceDao;
import service.serviceDaoImpl;

public class xiao extends HttpServlet{
	public static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String nei = request.getParameter("nei");
		serviceDao dao = new serviceDaoImpl();
		if(nei!=null) {
			boolean n=dao.addTo(nei); 
			boolean m=false;
			if(n) {
				m=true;
			}
			//List<Message> me =dao.cha();
			//��list����ת����json�ַ���
			 //String jsonObject = JSON.toJSONString(me);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print(m);//����
				out.flush();//ˢ��
				out.close();//�ر�
		}else {
			List<Message> me=dao.cha();
			String jsonObject = JSON.toJSONString(me);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(jsonObject);//����
			out.flush();//ˢ��
			out.close();//�ر�
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		this.doGet(request, response);
	}
}
