<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加页面</title>
</head>
<body>
<%
  	//News nn = new News();
   // newsDao nd=new newsDaoImpl();
	//List<News> lise=//nd.getAllnews();

  %>
    		<form action="insert" method="post">
			<h2>姓名：</h2>
  				<input type="text" name="qe" value=""></input><br>
		  <br>
		  <br>
		    <h2>性别：</h2>
  				<input type="text" name="qr" value=""></input><br>
		  <br>
		  <br>
  			<h2>内容：</h2>
  				<input type="text" name="qw" value=""></input><br>
		  <br>
		  <br>
		  <input type="submit" value="添加"/>
		  </form>
</body>
</html>