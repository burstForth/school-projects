$(document).ready(function(){
	$("#sub").attr({"disabled":"disabled"});
	$("#name").blur(function(){
		var name=this.value;
		//alert(name);
		if(name==null||name==""){
			$("#tips").html("用户名不能为空");
		}else{
			$.ajax({
				url     :    "register",
				type    :    "GET",
				data    :    "name="+name,
				dataType:    "text",
				success :    function(data){
					if(data == "true"){
						$("#tips").html("已被使用");
					}else{
						$("#sub").removeAttr("disabled");
						$("#tips").html("可以使用");
					}
				},
				error    :    function(){
					alert("异常");
				},
			});
		}
	})
});
function cho(){
	$("#sub").attr({"disabled":"disabled"});
}