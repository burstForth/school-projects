<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品展示页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<link href="css/main.css" rel="stylesheet" type="text/css">
<body>
<h2 align="center">购物车模块</h2>
<div class="main">
<div id="header">
<a href="shopping.jsp">我的购物车</a>&nbsp;&nbsp;<a href="order.jsp">我的订单</a></div><br>
<br>
<div id="center">
<c:forEach items="${page.list }" var="b">
书名：<a href='intro?id=${b.id }'>${b.book }</a><br><br>
</c:forEach>
</div>
<p align = "right" script="margin-bottom:10px;">当前页数：${page.currCount}/${page.totalPages}&nbsp;
  		<a href="main?d=1&p=${page.pageSize }">首页</a> 
  		<a href="main?d=${page.currCount-1}&p=${page.pageSize }">上一页</a>
  		<a href="main?d=${page.currCount+1}&p=${page.pageSize }">下一页</a>
  		<a href="main?d=${page.totalPages}&p=${page.pageSize }">末页</a> 
  		</p>
</div>
</body>
</html>