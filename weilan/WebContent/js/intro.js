 function gou(id){
	 //alert(id);
	 $.ajax({
	 	url:"intro",
		type:"post",
		data:"idd="+id,
		dataType:"text",
		success:function (){
			alert("添加成功");
		},
		error:function (){
			alert("异常");
		}
	});
 };


//$(document).ready(function(){
//	   function getUrlParam(name) {
//           var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
//           var r = window.location.search.substr(1).match(reg);  //匹配目标参数
//           if (r != null) return unescape(r[2]); return null; //返回参数值
//       }
	//var id=$("#id").href();
	//var c = getUrlParam('id');
	//var a =  window.location.search.substring(1);//(问号以后的字符串)
	//var b = a.substring(a.indexof('=')+1).toUpperCase();//(等号以后的字符串，及你所要的参数)
	//var a = UrlParam.paramValues("id"); 
	//alert(a);
//	$.ajax({
//		url:"intro",
//		type:"post",
//		data:"id="+c,
//		dataType:"text",
//		success:function (){
//			
//		},
//		error:function (){
//			
//		}
//		
//	});
//});

 