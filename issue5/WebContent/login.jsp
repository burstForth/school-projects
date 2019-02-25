<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>短信息</title>
</head>
<body>
 <form action="servlet" method="post">
 		登录名：<input type="text" name="uname"></input>
 		密码    ：<input type="text" name="upwd"></input>
 		<input type = "submit" name="upwd" value="登陆"></input>
 		<input type = "button" name="zhu" value="注册" onclick="location.href='register.jsp'"></input>
 </form>
</body>
</html>