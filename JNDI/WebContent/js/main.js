$(document).ready(function(){
	$.ajax({
		"url":"main",
		"type":"GET",
		"data":"",
		"dataType":"json",
		"success":function(data){
			//alert(data);
			if(data==null||data==""){
			}else{
				//$("#de").html("可以运行");
				//jsonData是该下路下的所有区间（json格式） 
//				 for (var i = 0; i < data.length; i++) {
//					 var nei=data[i].nei
//					 var id=data[i].mid
//					 $("#news").append("<h2>内容是："+nei+"</h2>"+"<h2>id是："+id+"</h2>");
//					 }
				//data=JSON.parse(data);//用each方法需要转换一下
				//遍历返回的集合
				$("#news").append("<h2 >重大新闻：</h2>");
				$("#news").append("<div><form action='up' enctype = 'multipart/form-data' method='post'>"+
		"选择文件：<input type='file' name='nfile' id=''filee'/>"+
		"<input type='submit' value='提交' id='up'/></form><p></div>");
				$(data.allnews).each(function(){
					$("#news").append(this.content+"<br>");
				});
				
				$("#news").append("<p id='you'>当前页："+
						data.currentPage+"/"+data.totalPages+
						"&#160;&#160;<a href='#' onclick='jjj("+1+","+data.pageSize+
						")'>首页</a>&#160;<a href='#' id='next1' onclick='jjj("+
						(data.currentPage-1)+","+data.pageSize+")'>上一页</a>&#160;<a href='#' id='next' onclick='jjj("+
						(data.currentPage+1)+","+data.pageSize+")'>下一页</a>&#160;<a href='#' onclick='jjj("+data.totalPages+","+data.pageSize+
						")'>尾页</a>");
			}
		},
		//jjj((data.currentPage+1),data.pageSize);
		"error":function(){
			alert("异常");
		},
	});
	$.ajax({
		"url":"xiao",
		"type":"GET",
		"data":"",
		"dataType":"json",
		"success":function(data){
			//alert(data);
			if(data==null||data==""){
			}else{
				$(data).each(function(){
					$("#txtCon1").append(this.nei+"<br>");
				});
			}
		},
		"error":function(){
			alert("异常");
		},
	});
});
//$(function(){
//	$("#next").click(function(){
//		
//		var data=this.attr("href");
//		alert(data);
//});
//});

function jjj(index,end){
	//alert(index);
	if(index==0){
		index=1;
	}
	//alert(index+","+end);
	$("#news").html("");
	$.ajax({
		"url":"main",
		"type":"GET",
		"data":{
			"index":index,
			"end":end
		},
		"dataType":"json",
		"success":function(data){
			//alert(data);
			if(data==null||data==""){
				alert("返回值为空");
			}else{
				$("#news").append("<h2 >重大新闻：</h2>");
				$("#news").append("<div><form action='up' enctype = 'multipart/form-data' method='post'>"+
						"选择文件：<input type='file' name='nfile' id=''filee'/>"+
						"<input type='submit' value='提交' id='up'/></form><p></div>");
				$(data.allnews).each(function(){
					$("#news").append(this.content+"<br>");
				});
				$("#news").append("<p id='you'>当前页："+
						data.currentPage+"/"+data.totalPages+
						"&#160;&#160;<a href='#' onclick='jjj("+1+","+data.pageSize+
						")'>首页</a>&#160;<a href='#' onclick='jjj("+(data.currentPage-1)+","+data.pageSize+")'>上一页</a>&#160;<a href='#' id='next' onclick='jjj("+
						(data.currentPage+1)+","+data.pageSize+")'>下一页</a>&#160;<a href='#'onclick='jjj("+data.totalPages+","+data.pageSize+
						")'>尾页</a>");
			}
		},
		"error":function(){
			alert("异常");
		},
	});
};
$(function(){
	$("#find").click(function(){
		$("#xi").show();
});
});
$(function(){
	$("#send").click(function(){
		var nei=$("#shu").val();
		if(nei==""||nei==null){
			alert("内容不能为空！");
		}
		//alert(nei);
		$.ajax({
			url :"xiao",
			type :"post",
			data :"nei="+nei,
			dataType :"text",
			success :function(data){
				if(data=="true"){
					$("#txtCon").append(nei+"<br>");
					$("#txtCon1").append(nei+"<br>");
					$("#shu").val("");
				}else{
					alert("发送失败");
				}
			},
			error :function(){
				alert("异常");
			},
		});
	});
});
$(function(){
	$("#find").click(function(){
		$("#xi").show();
});
});
//删除操作
$(function(){
	$("#delete").click(function(){
		$.ajax({
			url:"delete",
			type:"post",
			data:"",
			dataType:"text",
			success:function(data){
				if(data==null||data==""){
					alert("删除失败");
				}else{
					alert("删除成功");
					$("#txtCon1").val("");
				}
			},
			error:function(){
				alert("异常");
			}
		});
	});
});
$(function(){
	$("#sd").click(function(){
		//$("#txtCon1").val("");
		$("#xi").hide();
		
	});
});
$(function(){
	$("#d1").click(function(){
		//$("#txtCon1").val("");
		$("#txtCon").val("");
		
	});
});