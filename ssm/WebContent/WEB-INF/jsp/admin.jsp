<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<style type="text/css">
	#left{
		float:left;
		width:20%;
	}
	#righte{
		float:left;
		width:70%;
		border:1px solid black;
	}
</style>
</head>
<body>
<header  id="header">
	<h1 align="center">欢迎来到管理员操作系统</h1>
</header>
	<div id="left">
		<input type="button" value="密码修改" onclick="mixiu()">
		<br>
		<br>
		<input type="button" value="系统管理" onclick="xiguan()">
		<br><br>
		<input type="button" value="课程管理" onclick="keguan()"><br>
		<input type="button" value="课程录入" onclick="kelu()">
		<br><br>
		<input type="button" value="老师管理" onclick="laoguan()"><br>
		<input type="button" value="老师录入" onclick="laolu()">
		<br><br>
		<input type="button" value="课表管理" onclick="biaoguan()"> <br>
		<input type="button" value="课表录入" onclick="biaolu()"> 
		<br>
		<br>
		<input type="button" value="学生管理" onclick="xueguan()"> <br>
		<input type="button" value="学生录入" onclick="xuelu()"> 
	</div>
	
	<div id="right">
			<h5 align="center">欢迎来到学生管理系统</h5>
	</div>
</body>
</html>