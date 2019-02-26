<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生登陆页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/studento.js"></script>
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
</style>
</head>
<header  id="header">
	<h1 align="center">欢迎来到学生操作系统</h1>
</header>
<body>

	<div id="left">
		<input type="button" value="个人信息" onclick="mes()">
		<br>
		<input type="button" value="课表信息" onclick="ke()">
		<br>
		<!-- <input type="button" value="我的选课" onclick="xuan()"> -->
	</div>
	<div id="right">
	<h3>欢迎光临</h3>
	</div>
</body>
</html>