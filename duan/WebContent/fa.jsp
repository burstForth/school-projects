<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="back2">返回</a>
<form action="fa?uid=${sf.id }" method="post">
		<select name="select">
		<c:forEach items="${list}" var = "u">
			<option value="${u.uid}">${u.user}</option><br/>
		</c:forEach>
		</select>
		<input type="text" name="nei"/>
		<input type="submit" value="发送">
		</form>
</body>
</html>