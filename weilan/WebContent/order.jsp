<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<!-- <script type="text/javascript" src="js/order.js"></script> -->
</head>
<body>
<div align="center">
<br><br>
<a href="main.jsp">主页</a>&nbsp;&nbsp;&nbsp;<a href="shopping.jsp">我的购物车</a><br><br><br>
<c:forEach items="${dog.list }" var="b">
书名：${b.book }&nbsp;&nbsp;&nbsp;&nbsp;价格：${b.price }&nbsp;&nbsp;&nbsp;&nbsp;
订单编号：${b.id}&nbsp;&nbsp;&nbsp;&nbsp;商品编号：${b.sid }<br><br>
</c:forEach>
<%-- <p align = "right" script="margin-bottom:10px;">当前页数：${dog.currCount}/${dog.totalPages}&nbsp;
  		<a href="order?d=1&p=${dog.pageSize }">首页</a> 
  		<a href="order?d=${dog.currCount-1}&p=${dog.pageSize }">上一页</a>
  		<a href="order?d=${dog.currCount+1}&p=${dog.pageSize }">下一页</a>
  		<a href="order?d=${dog.totalPages}&p=${dog.pageSize }">末页</a> 
  		</p> --%>
  		</div>
</body>
</html>