<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆页面</title>
<script type="text/javascript" src="js/login.js"></script><!-- 引入js文件 -->
<link href="css/login.css" rel="stylesheet" type="text/css" /><!-- 引入css文件 -->
<script type="text/javascript">

</script>
</head>
<body>
<center>
	<form action="login" method="post">
	<div id="div"></div>
		用户名：<input type="text" name="user" id="user"></input><br>
		<br>
		密&#160;&#160;&#160;码    ：<input type="password" name="pa"id="pa"></input><br>
		<br>
		&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
		<input type="submit" value="登陆" onclick="jian()"></input>
		&#160;&#160;<input type="button" value="注册" onclick="location.href='register.jsp'"></input>
	</form>
</center>
</body>
</html>