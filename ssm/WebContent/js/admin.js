	$(document).ready(function(){
		$.post("admin",function(data){
			alert("欢迎登陆管理员系统");	
		})
	});
function mixiu(){
	$("#right").html("");
	$("#right").append("<form action='gai' method='post'>"+
	"登录名："+"<input type='text' name='userName'/>"+
	"原密码：<input type='text' name='userPw'>"+
	"新密码：<input type='text' name='xinPw'>"+
	"<input type='submit' value='提交'>"+
	"<input type='reset' value='重置'>"+
"</form>")
}
function xiguan(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/xiguan.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function keguan(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/keguan.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function kelu(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/kelu.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function laoguan(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/laoguan.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function laolu(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/laolu.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function biaoguan(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/biaoguan.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function biaolu(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/biaolu.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function xueguan(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/xueguan.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}
function xuelu(){
	$("#right").html("");
	$("#right").append("<div id='html_1'><iframe align='center' width='950' height='500' src='page/xuelu.jsp' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='no'></iframe></div>")
}


