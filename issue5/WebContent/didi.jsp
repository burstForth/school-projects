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
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理页面</title>
</head>
<body>


  		<p align = "right" script="margin-bottom:10px;">当前页数：${page.currPage}/${page.totalPageCount}&nbsp;
  		<a href="fenye?index=1&pageSize=${page.pageSize}">首页</a> 
  		<a href="fenye?index=${page.currPage-1}&pageSize=${page.pageSize}">上一页</a>
  		<a href="fenye?index=${page.currPage+1}&pageSize=${page.pageSize}">下一页</a>
  		<a href="fenye?index=${page.totalPageCount}&pageSize=${page.pageSize}">末页</a> 
  		</p>
  		
  

</body>
</html>