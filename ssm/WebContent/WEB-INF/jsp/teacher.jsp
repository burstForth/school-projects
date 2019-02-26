<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>老师管理页面</title>
<style type="text/css">
	#left{
		width:20%;
		/* border:1px solid black; */
		 float:left;
	}
	#right{
		 width:75%; 
		
		 /* border:1px solid black;
		 height:80%; */
		 float:left;
		
	}
</style>
</head>
<header  id="header">
	<h1 align="center">欢迎来到教师操作系统</h1>
</header>
<body>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>

<div id="left">
	<input type="button" value="个人信息" onclick="mes()">
	<br>
	<br>
	<input type="button" value="课表浏览" onclick="ke()">
</div>
<div id="right">
	<!-- <iframe align='center' width='950' height='500' src='page/kebiao.jsp' ></iframe> -->
</div>
</body>
</html>