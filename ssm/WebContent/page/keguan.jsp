<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理页面</title>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function del(id){
		//alert(id);
	 	$.ajax({
			url:"../delone",
			type:"post",
			data:"ide="+id,
			dataType:"json",
			success:function(data){
				alert("删除成功");
				//alert(data);
				$("#maina").html("");
				$(data).each(function(){
					$("#maina").append("课程编号："+this.bianhao+"&nbsp;课程名称："+this.mingcheng+"&nbsp;课时 ："+this.keshi+"&nbsp;<input type='button' value='删除' onclick='del("+this.id+")'><br><br>")
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
	<c:forEach items="${kz}" var="c" varStatus="st">
	            课程编号：${c.bianhao}
	&nbsp;课程名称：${c.mingcheng}
	&nbsp;课时：${c.keshi}
	      <input type="button" value="删除" onclick="del(${c.id})"><br><br>
	</c:forEach>
	</div>
</body>
</html>