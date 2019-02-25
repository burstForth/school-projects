$(function(){
	$("#bu").click(function(){
		//alert("shibai");
		var account=$("#account").val();
		var password=$("#password").val();
		$.ajax({
			url:"login",
			type:"post",
			data:"name="+account+"&password="+password,
			dateType:"text",
			success:function(data){
				if(data=="true"){
					window.location.href="main.jsp";
				}else{
					alert("用户名或密码错误");
				}
			},
			error:function(){
				alert("异常");
			},
		});
	});
});
$(function(){
	$("#register").click(function(){
		window.open("register.jsp");
	});
});

