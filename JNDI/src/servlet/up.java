package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Message;
import entity.file;
import service.serviceDao;
import service.serviceDaoImpl;


public class up extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("����˭");
		request.setCharacterEncoding("utf-8");//�����ַ���
		String uploadFileName ="";//�ϴ����ļ���
		String fieldName = "";//���ֶ�Ԫ�ص�name����ֵ
		
		//������Ϣ�е������Ƿ���multipart����
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		//�ϴ��ļ��Ĵ洢·�����������ļ�ϵͳ�ϵľ����ļ�·����
		String uploadFilePath = request.getSession().getServletContext().getRealPath("images/");
		System.out.println("�ϴ��ļ���·��"+uploadFilePath);
		
		//�ж�indexҳ���з��͵������Ƿ�Ϊmultipart���͵�
		if(isMultipart) {
			
			//��Ҫ������װͼƬ���û�Ϊһ��fileItemFactoryʵ��Ϊ�˷����Ժ�ͳһ�ӿڷ����ļ�����Ϣ
			FileItemFactory factory = new DiskFileItemFactory();
			
			//��form���е�ÿ�������װ��һ��fileItem
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try{
				//ʹ��uploadʵ��������form��������������ļ�������ŵ�items��
				List<FileItem> items=upload.parseRequest(request);
				
				//out.println(items);
				
				//��ȡһ����Ӧ�ĵ�����
				Iterator<FileItem> iter = items.iterator();
				
				//out.println(iter);
				
				//�Դδ���ÿ���ļ�--iter.hasNext()���ж��Ƿ�����һ��Ԫ�� 
				while(iter.hasNext()){
					FileItem item = (FileItem) iter.next();//�õ���һ��Ԫ�� 
					
					//out.println(item);
					
					//�ж��Ƿ�����ͨ���ֶ�
					if(item.isFormField()) {
						
						//���ֶε�name����ֵ
						fieldName = item.getFieldName();
						
						//out.println(fieldName);
						
						//�Ƿ�Ϊ���� �ǣ�����������Ϣ
						if(fieldName.equals("user")) {
							
							//������ֶε�ֵ
							//System.out.print(item.getString("utf-8")+"�ϴ����ļ���<br/>");
						}
						}else{//�ļ����ֶ�
							//out.println("ncai");
							String fileName = item.getName();
							String name = item.getFieldName();
							if(fileName != null && !fileName.equals("")) {
								//��ȡ�ļ���
								File fullFile = new File(item.getName());
								
								//��ȡ·�����ļ�������
								File saveFile = new File(uploadFilePath, fullFile.getName());
								item.write(saveFile);
								
								uploadFileName = fullFile.getName();
								//System.out.print("�ϴ��ɹ�����ļ����ǣ�"+uploadFileName);
								
								serviceDao da = new serviceDaoImpl();
								boolean b =da.up(uploadFilePath);
								response.setContentType("text/html; charset=UTF-8");//�����ַ���
								PrintWriter out=response.getWriter();	
								if(b){
									//int n=1;
									//request.getSession().setAttribute("n",n);
									out.flush();
									out.print("<script>");
									out.print("alert('�ϴ��ɹ�');");
									out.print("location.href='main.jsp';");
									out.print("history.back();");
									out.print("</script>");
									//response.sendRedirect("main.jsp");
//									out.println(b);
//									out.flush();
//									out.close();
								}else{
									//int n=2;
									//request.getSession().setAttribute("n",n);

									out.print("<script>");
									out.print("alert('�ϴ�ʧ��');");
									out.print("location.href='main.jsp';");
									out.print("history.back();");
									out.print("</script>");
									//out.print("<script>alert('�ϴ�ʧ��');location.href='main.jsp';</script>");
									//response.sendRedirect("main.jsp");
								}
							}//if
						}//else	
				
			}//while
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("vsndk");
			}
		}else{
			System.out.print("adnfk");
		}
		//response.sendRedirect("didi.jsp");		
	}

}
