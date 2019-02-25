$(function(){
	$("#butt").attr({"disabled":"disabled"});
	$("#acc").blur(function(){
		var account=$("#acc").val();
		if(account==""){
			alert("用户名不能为空！");
		}else{
		$.ajax({
			url:"register",
			type:"post",
			data:"account="+account,
			dataType:"text",
			success:function(data){
				if(data=="true"){
					alert("该用户已注册！");
					$("#acc").val("");
				}else{
					$("#tips").html("可以使用!");
				}	
			},
			error:function(){
				alert("异常");
			}
		});
		}
	});
	$("#password").blur(function(){
		var password=$("#password").val();
		if(password==""||password==null){
			alert("密码不能为空！");
		}
	});
	$("#pa1").blur(function(){
		var password=$("#password").val();
		var pa=$("#pa1").val();
		if(password!=pa){
			alert("密码不一致");
		}else{
			$("#butt").removeAttr("disabled");
		}
	});
	$("#butt").click(function(){
		var account=$("#acc").val();
		var password=$("#password").val();
		$.ajax({
			url:"register",
			type:"post",
			data:"account="+account+"&password="+password,
			dataType:"text",
			success:function(data){
				if(data=="true"){
					alert("注册成功！点击确定返回登陆页面");
					window.close();
				}else{
					alert("注册失败！");
				}	
			},
			error:function(){
				alert("异常");
			}
		});
	});
});