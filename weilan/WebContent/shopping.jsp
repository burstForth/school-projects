<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/shopping.js"></script>
</head>
<body>
<div align="center">
<a href="main.jsp">主页</a>&nbsp;&nbsp;&nbsp;<a href="order?d=1&p=2">我的订单</a><br><br><br>
<div id = "maina">
	<c:forEach items="${pagee.list }" var="b">
	书名：<a href='#'>${b.book }</a>
	价格：${b.price }&nbsp;<input type="button" value="购买" onclick="boo(${b.id })"><br><br>
	</c:forEach>
</div>
</div>
</body>
</html>