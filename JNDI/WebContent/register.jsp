<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
 <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="js/json.js"></script>
 <script type="text/javascript" src="js/register.js"></script>

<!-- <script type="text/javascript">
	//原始ajax
 	//创建Ajax对象
 	var xml=null;
 	function cli(){
 		var name=$("#name").val();
 		if(name==null||name==""){
 			$("#tips").html("用户名不能为空");
 		}else{
 			xml=sdf();
 			xml.onreadystatechange=hui;
 			var url="register?name="+name;
 			//var data="name="+name;
 			xml.open("Get",url,true);
 			//xml.setRepuestHeader("Content-Type","application/x-www-form-urlencoded");
 			xml.send(null);
 			
 			function hui(data){
 		 		if(xml.readyState==4 && xml.status==200){
 		 			date=xml.responseText;
 		 			if(data=="true"){
 		 				$("#tips").html("用户已存在");
 		 			}else{
 		 				$("#tips").html("用户可以使用");
 		 			}
 		 		}
 		 	}
 		 }
 		}
 	function sdf(){
 		if(window.XMLHttpRequest){
 			return new XMLHttpRequest();
 		}else{
 			return new ActiveXobject("Microsoft.XMLHTTP");
 		}
 		}
 </script> -->
<body>
<div id="di"></div>
<select id="srl"></select>
<ul id="ul"></ul>
<div id="ob"></div>
	<center>
		<form action="register" method="get">
			用户名：<input type="text" name="name" id="name"/></p>
			密码：<input type="password" name="pass" id="pass"/></p>
			请再次输入密码：<input type="password" name="pass1" id="pass1"/></p>
			<input type="submit" id="sub" value="注册"/>
			<input type="reset" id="set" value="重置" onclick="cho()"/></p>
			<div id="tips"></div>
		</form>
	</center>
</body>

</html>