<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课表管理页面</title>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function del(id){
		//alert(id);
	 	$.ajax({
			url:"../delthree",
			type:"post",
			data:"ide="+id,
			dataType:"json",
			success:function(data){
				alert("删除成功");
				//alert(data);
				$("#maina").html("");
				$(data).each(function(){
					$("#maina").append("课程编号："+this.bianhao+"&nbsp;课程名称："
					+this.mingcheng+"&nbsp;课时 ："+this.keshi+"时间："
					+this.shijian+"节次："+this.jieci
					+"教室："+this.jiaoshi+"老师："+this.laoshi
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
	<c:forEach items="${bc}" var="c" varStatus="st">
	            	    课程编号：${c.bianhao}
	            &nbsp;课程名称：${c.mingcheng}
	            &nbsp;课时：${c.keshi}
	            &nbsp;时间：${c.shijian}
	            &nbsp;节次：${c.jieci}
	            &nbsp;教室：${c.jiaoshi}
	            &nbsp;老师：${c.laoshi}
	      <input type="button" value="删除" onclick="del(${c.id})"><br><br>  
	</c:forEach>
	</div>
</body>
</html>