$(document).ready(function(){
	var index=1;
	var pageSize=5;
		
		$.ajax({
			url:"order",
			type:"post",
			data:"d="+index+"&p="+pageSize,
			dataType:"text",
			success:function(){
				//alert("欢迎来到蔚蓝网！");
			},
			error:function(){
				alert("异常");
			}
		});
		$.ajax({
			url:"shopping",
			type:"post",
			data:"d="+index+"&p="+pageSize,
			dataType:"text",
			success:function(){
				//alert("欢迎来到蔚蓝网！");
			},
			error:function(){
				alert("异常");
			}
		});
});