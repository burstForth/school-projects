<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- jstl必须 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详情页</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/intro.js"></script>
</head>
<body>
<a href="main.jsp">返回</a><br>
<c:forEach items="${intro }" var="b">
书名：${b.book }<br>
作者：${b.author }<br>
出版社：${b.press }<br>
出版时间：${b.time }<br>
详细简介：${b.intro }<br>
价格：${b.price }<br>
<input type="button" value="放入购物车" onclick="gou(${b.id})">
</c:forEach>

</body>
</html>