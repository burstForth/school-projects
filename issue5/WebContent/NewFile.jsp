<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.fei.util.*" %>
    <%@page import="com.fei.entity.*" %>
    <%@page import="com.fei.dao.impl.*" %>
    <%@page import="com.fei.daoa.*" %>
    <%@page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
</head>
<body>
<%
//接受下拉选框的name值
/* String a=request.getParameter("select");
//类型转换把String转换成int类型的--普通强转不行必须用int的包装类进行强制性转换--这样就可以获取下拉选框的value值了
Integer e = Integer.valueOf(a);
//打印
out.print(e); */
//步骤同上
/* //接受a标签的值
String a=request.getParameter("id");
Integer e = Integer.valueOf(a);
out.print(e); */

 %>
   <%
  	//News nn = new News();
   // newsDao nd=new newsDaoImpl();
	//List<News> lise=//nd.getAllnews();
	String a=request.getParameter("id");
    Integer e = Integer.valueOf(a);
    session.setAttribute("idd", e);
    out.print(e);
  %>
    		<form action="xiu" method="post">
  <h2>主题：</h2>
  <select name="select">
  			<option value="1"/>国内
  			<option value="2"/>国外
  </select>
  <h2>内容：</h2>
  <input type="text" name="qw" value=""></input><br>
		  <br>
		  <br>
		  <input type="submit" value="修改"/>
		  </form>
</body>
</html>