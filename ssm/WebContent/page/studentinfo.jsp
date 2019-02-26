<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
</head>
<body>
	<c:forEach items="${ma}" var="c" varStatus="st">
	            学号：                  ${c.xuehao}<br>
	            姓&nbsp;&nbsp;名：${c.xingming}<br>
	            性&nbsp;&nbsp;别：${c.xingbie}<br>
	            年&nbsp;&nbsp;龄：${c.nianling}<br>        
	            班&nbsp;&nbsp;级：${c.banji}<br> 
	            登陆账号：		   ${c.loginname}<br> 
	            登陆密码：		   ${c.loginpw}<br> 
	</c:forEach>

</body>
</html>