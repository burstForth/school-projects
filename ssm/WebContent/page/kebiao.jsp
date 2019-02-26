<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>课程表</title>
</head>
<body>
 <c:forEach items="${bc}" var="c" varStatus="st">
	            课程编号：${c.bianhao}<br>
	            课程名称：${c.mingcheng}<br>
	            课时：${c.keshi}<br>
	            时间：${c.shijian}<br>
	            节次：${c.jieci}<br>
	            教室：${c.jiaoshi}<br>
	            老师：${c.laoshi}<br><br>
	</c:forEach>
</body>
</html>