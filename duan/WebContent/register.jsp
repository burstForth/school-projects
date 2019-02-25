  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<script type="text/javascript">
		function click(){
			var x=document.forms["name"]["pass"].value;

			if (x==null || x==""){

			alert("昵称必须填写");

			return false;

			}
		}
		
</script>
<body>
	<center>
		<form action="zhu" method="post" onsubmit = "return click()">
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
		  <input type="submit" value="注册" id="btn"/>
		  <input type="reset" value="重  置">
		  
		  </form>
	</center>
</body>
</html>