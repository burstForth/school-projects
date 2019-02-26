<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理页面</title>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function del(id){
		//alert(id);
	 	$.ajax({
			url:"../delfour",
			type:"post",
			data:"ide="+id,
			dataType:"json",
			success:function(data){
				alert("删除成功");
				//alert(data);
				$("#maina").html("");
				$(data).each(function(){
					$("#maina").append("学号："+this.xuehao+"&nbsp;姓名："
					+this.xingming+"&nbsp;性别 ："+this.xingbie+"年龄："
					+this.nianling+"班级："+this.banji
					+"登陆账号："+this.loginname+"登陆密码："+this.loginpw
					+"&nbsp;<input type='button' value='删除' onclick='del("+this.id+")'><br><br>")
				});
			},
			error:function(){
				alert("异常");	
			}
		}); 
}
</script>
</head>
<body>
<div id="maina">
	<c:forEach items="${sl}" var="c" varStatus="st">
	            学号：                  ${c.xuehao}
	            &nbsp;姓&nbsp;&nbsp;名：${c.xingming}
	            &nbsp;性&nbsp;&nbsp;别：${c.xingbie}
	            &nbsp;年&nbsp;&nbsp;龄：${c.nianling}       
	            &nbsp;班&nbsp;&nbsp;级：${c.banji}
	            &nbsp;登陆账号：		   ${c.loginname} 
	            &nbsp;登陆密码：		   ${c.loginpw}
	      &nbsp;<input type="button" value="删除" onclick="del(${c.id})"><br><br>
	</c:forEach>
	</div>
</body>
</html>