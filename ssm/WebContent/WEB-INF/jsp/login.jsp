<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
	<div>
		用户名：<input type="text" name="userName">
		密&nbsp;&nbsp;码：<input type="text" name="userPw">
		<select class="radius3" name="userType" style="width: 150px;">
	                                <option value="0">管理员</option>
	                                <option value="1">老&nbsp;&nbsp;&nbsp;师</option>
	                                <option value="2">学&nbsp;&nbsp;&nbsp;生</option>
							 </select>
		<input type="submit" value="登陆">
	</div>
</form>
</body>
</html>