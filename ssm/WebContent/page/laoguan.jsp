<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>老师管理页面</title>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function del(id){
		//alert(id);
	 	$.ajax({
			url:"../deltwo",
			type:"post",
			data:"ide="+id,
			dataType:"json",
			success:function(data){
				alert("删除成功");
				//alert(data);
				$("#maina").html("");
				$(data).each(function(){
					$("#maina").append("教师编号："+this.bianhao+"&nbsp;姓名："
					+this.xingming+"&nbsp;性别 ："+this.xingbie+"年龄："
					+this.nianling+"职称："+this.zhicheng
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
	    <c:forEach items="${tl}" var="c" varStatus="st">
	    
	                          教师编号：                                ${c.bianhao}
	            &nbsp;姓&nbsp;&nbsp;名： ${c.xingming}
	            &nbsp;性&nbsp;&nbsp;别： ${c.xingbie}
	            &nbsp;年&nbsp;&nbsp;龄： ${c.nianling}        
	            &nbsp; 职&nbsp;&nbsp;称：${c.zhicheng} 
	            &nbsp;登陆账号：		    ${c.loginname}
	            &nbsp;登陆密码：		    ${c.loginpw}
	     <input type="button" value="删除" onclick="del(${c.id})"><br><br> 
	    </c:forEach>
</div>
</body>
</html>