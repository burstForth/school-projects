<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
function jian(){
	var name=document.getElementById("name").value;
	var pa=document.getElementById("pass").value;
	if(name==""&&pa==""){
		alert("用户名和密码不能为空！");
	}
}
</script>
</head>
<body>
<div id="demo" style="height:30px;"></div>
	<center>
		<form action="zhu" method="post">
			<h2>请输入用户名：</h2>
  				<input type="text" name="qe" value="" id= "name" placeholder="请输入用户名"></input><br>
		  <br>
		  <br>
		    <h2>请输入密码：</h2>
  				<input type="text" name="qr" value="" id= "pass" placeholder="请输入密码"></input><br>
		  <br>
		  <br>
  			<h2>请再次输入密码：</h2>
  				<input type="text" name="qw" value="" id= "pas"  placeholder="请再次输入密码"></input><br>
		  <br>
		  <br>
		  <input type="submit" value="注册" id="btn" onclick="click()"/>
		   <input type="button" value="提交" id="btn"onclick=""/>
		  <input type="reset" value="重  置">
		  
		  </form>
	</center>
</body>
</html>