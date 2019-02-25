<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复</title>
</head>
<body>
	收件人姓名：${ue.user }<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<form action="insert?id=${ue.id }&iid=${ere}&name=${ue.id}" method="post">
	<input type="text" name="nei"/>
	<input type="submit"align="right" value="发送"/>       
	</form>
</body>
</html>