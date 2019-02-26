//$(document).ready(function(){
//	//main(1,5);
//	var index=1;
//	var pageSize=5;
//		if(index==""&&index==null&&index==0){
//			index=1;
//		}
//		if(pageSize==""&&pageSize==null&&pageSize==0){
//			index=5;
//		}
//		$.ajax({
//			url:"shopping",
//			type:"post",
//			data:"d="+index+"&p="+pageSize,
//			dataType:"text",
//			success:function(){
//				//alert("欢迎来到蔚蓝网！");
//			},
//			error:function(){
//				alert("异常");
//			}
//		});
//	
//});
function boo(id){
	//var n=$("#bo").attr("href");获取a标签 href属性
	//alert(id);
	$.ajax({
		url:"shopping",
		type:"post",
		data:"dd="+id,
		dataType:"json",
		success:function(data){
			alert("付款成功，请到我的订单中查看");
			$("#maina").html("");
			$(data.list).each(function(){
				id
				$("#maina").append(id+"书名："+this.book+"&nbsp;价格："+this.price+"<input type='button' value='购买' onclick='boo("+this.id+")'><br><br>")
			});
		},
		error:function(){
			alert("异常");
		}
	});
}
 function shopp(index,pageSize){
	 if(index==""&&index==null&&index==0){
			index=1;
		}
		if(pageSize==""&&pageSize==null){
			index=5;
		}
		//alert(index);
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
 }
 