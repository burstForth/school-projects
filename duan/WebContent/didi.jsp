<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="com.fei.util.*" %>
    <%@page import="com.fei.entity.*" %>
    <%@page import="com.fei.dao.impl.*" %>
    <%@page import="com.fei.daoa.*" %>
    <%@page import ="java.util.List" %>
    <%@page import="java.io.*,java.util.*" %>
    <%@page import="org.apache.commons.fileupload.*" %>
    <%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
    <%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理页面</title>
</head>
<body>
<%-- ${sf.user }
${name } --%>
		<a href="fa?id=${sf.id }">发短消息</a> <a href="back">退出</a><br/><br/>
			<%-- <c:forEach items="${du }" var="c">
			${c.fid }
            ${c.id }
            ${c.uid }
			<a href="#" onclick="alert('${c.nei }')">${c.nei }</a>
			<a href="cha?id=${c.uid }&iid=${c.id }">回复</a>
			<a href="shan?id=${c.fid }&uname=${sf.user }">删除</a><br/>
			</c:forEach> --%>
				<c:forEach items="${lis }" var="b">
			<%-- ${c.fid }
            ${c.id }
            ${c.uid } --%>
			<a href="#" onclick="alert('${b.nei }')">${b.nei }</a>
			<a href="cha?id=${b.uid }&iid=${b.id }">回复</a>
			<a href="shan?id=${b.fid }&uname=${sf.user }">删除</a><br/>
			</c:forEach>
			<c:choose>
				<c:when test="${page.totalCount-page.pageSize}=1">
					${page.pageSize}=${page.pageSize}+1;
					out.print(${page.pageSize});
				</c:when>
			</c:choose>
		<p align = "right" script="margin-bottom:10px;">当前页数：${page.currPage}/${page.totalPageCount}&nbsp;
  		<a href="fenye?index=1&pageSize=${page.pageSize}">首页</a> 
  		<a href="fenye?index=${page.currPage-1}&pageSize=${page.pageSize}">上一页</a>
  		<a href="fenye?index=${page.currPage+1}&pageSize=${page.pageSize}">下一页</a>
  		<a href="fenye?index=${page.totalPageCount}&pageSize=${page.pageSize}">末页</a> 
  		</p>
</body>
</html>