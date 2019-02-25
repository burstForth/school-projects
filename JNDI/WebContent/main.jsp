<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.*,java.util.*" %>
    <%@page import="org.apache.commons.fileupload.*" %>
    <%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
    <%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link href="css/main.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<div id="nei"></div>
<div id="di"></div>
<div id="de"></div>
<!--  style="display:none;"隐藏 -->
<div id="news">


</div>
<div id="bottom">
<h2 >聊天区：</h2><p color="red">每刷新一次就会清空内容</p>
<textarea id="txtCon" rows="15" cols="75"></textarea>
<input type="button" id="find" value="聊天记录"  />
<div id="xi" style="display:none;">
<textarea id="txtCon1" rows="13" cols="20" ></textarea>
<input type="button" value="清除聊天记录" id="delete"/>
<input type="button" value="关闭聊天记录" id="sd"/>
</div>
<input type="text" size="100" id="shu" value=""></input>
<input type="button"id="send" value="发送"></input>
<input type="button" id="d1" value="清除聊天内容"  />
</div>
</body>
</html>