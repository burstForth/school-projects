$(document).ready(function(){
	$.ajax({
		"url":"cha",
		"type":"get",
		"data":"",
		"dataType":"text",
		"success":function(data){
			if(data==null||data==""){
				$("#di").append("id:"+user.id+"<br>")
				.append("用户名:"+user.name+"<br>")
				.append("密码:"+user.pwd+"<br>");
			}
		},
		"error":function(){
			
		},
	});
});