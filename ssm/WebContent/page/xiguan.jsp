<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理页面</title>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>

</head>
<body>
<div id="maina">
	<c:forEach items="${cg}" var="c" varStatus="st">
	            用户：${c.userName}
	      &nbsp;密码：${c.userPw}
	      <input type="button" value="删除" onclick="del(${c.userId})"><br>
	      <br>
	</c:forEach>
</div>
</body>
<script type="text/javascript">
	function del(id){
		//alert(id);
	 	$.ajax({
			url:"../dell",
			type:"post",
			data:"ide="+id,
			dataType:"json",
			success:function(data){
				alert("删除成功");
				//alert(data);
				$("#maina").html("");
				$(data).each(function(){
					$("#maina").append("用户："+this.userName+"&nbsp;密码："+this.userPw+"<input type='button' value='删除' onclick='del("+this.userId+")'><br><br>")
				});
			},
			error:function(){
				alert("异常");	
			}
		}); 
}
</script>
</html>