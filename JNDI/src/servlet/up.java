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
		//System.out.println("你是谁");
		request.setCharacterEncoding("utf-8");//设置字符集
		String uploadFileName ="";//上传的文件名
		String fieldName = "";//表单字段元素的name属性值
		
		//请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		//上传文件的存储路径（服务器文件系统上的绝对文件路径）
		String uploadFilePath = request.getSession().getServletContext().getRealPath("images/");
		System.out.println("上传文件的路径"+uploadFilePath);
		
		//判断index页面中发送的请求是否为multipart类型的
		if(isMultipart) {
			
			//主要生产封装图片和用户为一个fileItemFactory实例为了方便以后统一接口访问文件的信息
			FileItemFactory factory = new DiskFileItemFactory();
			
			//将form表单中的每项输入封装成一个fileItem
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try{
				//使用upload实例来解析form表单中请求的所有文件并将其放到items中
				List<FileItem> items=upload.parseRequest(request);
				
				//out.println(items);
				
				//获取一个相应的迭代器
				Iterator<FileItem> iter = items.iterator();
				
				//out.println(iter);
				
				//以次处理每个文件--iter.hasNext()是判断是否有下一个元素 
				while(iter.hasNext()){
					FileItem item = (FileItem) iter.next();//得到下一个元素 
					
					//out.println(item);
					
					//判断是否是普通表单字段
					if(item.isFormField()) {
						
						//表单字段的name属性值
						fieldName = item.getFieldName();
						
						//out.println(fieldName);
						
						//是否为文字 是：输入文字信息
						if(fieldName.equals("user")) {
							
							//输出表单字段的值
							//System.out.print(item.getString("utf-8")+"上传了文件。<br/>");
						}
						}else{//文件表单字段
							//out.println("ncai");
							String fileName = item.getName();
							String name = item.getFieldName();
							if(fileName != null && !fileName.equals("")) {
								//获取文件名
								File fullFile = new File(item.getName());
								
								//获取路径加文件的名字
								File saveFile = new File(uploadFilePath, fullFile.getName());
								item.write(saveFile);
								
								uploadFileName = fullFile.getName();
								//System.out.print("上传成功后的文件名是："+uploadFileName);
								
								serviceDao da = new serviceDaoImpl();
								boolean b =da.up(uploadFilePath);
								response.setContentType("text/html; charset=UTF-8");//设置字符集
								PrintWriter out=response.getWriter();	
								if(b){
									//int n=1;
									//request.getSession().setAttribute("n",n);
									out.flush();
									out.print("<script>");
									out.print("alert('上传成功');");
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
									out.print("alert('上传失败');");
									out.print("location.href='main.jsp';");
									out.print("history.back();");
									out.print("</script>");
									//out.print("<script>alert('上传失败');location.href='main.jsp';</script>");
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
