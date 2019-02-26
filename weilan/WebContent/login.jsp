	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆页面</title>
</head>
<body>
<%
String s=request.getParameter("ds");
if(s==null){
	response.sendRedirect("main");
}
%>
请点击<a href="main?d=1&p=5">登陆</a>
</body>
</html>