	function jian(){
		var name=document.getElementById("user").value;
		var pa=document.getElementById("pa").value;
		if(name==""||pa==""){
			alert("用户名和密码不能为空！");
		}
	}
/*XMLHttpRequest 的常用方法
 * open(String method,String url,boolean async,String user,String password) 
											创建一个新的HTTP请求
send( String  data )    					发送请求到服务器端
abort( )									取消当前请求
setRequestHeader(String header,String value)设置请求的某个HTTP头信息
getResponseHeader(String header)			获取响应的指定HTTP头信息
getAllResponseHeader( )						获取响应的所有HTTP头信息*/


