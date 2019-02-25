var main;
$(document).ready(function(){
	//alert("kvsn");
main();
});
main=function main(currPage,pageSize){
	$("#center").html("");
	$("#pagee").html("");
	if(currPage==null||currPage==""){
		currPage="1";
	} 
	if(currPage==0){
		currPage="1";
	}
	if(pageSize==null||pageSize==""){
		pageSize="5";
	}
	//alert(currPage+pageSize);
		$.ajax({
			url:"main",
			type:"post",
			data:{
				"currPage":currPage,
				"pageSize":pageSize 
				  },
			dataType:"json",
			success:function(data){
/*				遍历map集合
 *				 var da=data.list;
				
				$.each(da,function(k,v){
					console.log(k); 
					console.log(v);
					$(v).each(function(){
						alert(this.topic+this.news);
					});
				});
				for(var i in da){i为键
					alert(da.get(i));
				}*/
				//alert(data.list);
				$(data.list).each(function(){
					$("#center").append("主题是："+this.topic+"<a href='#'>"+this.news+"</a>&nbsp;作者："+this.author+"<br>");
				});
				$(data).each(function(){
					$("#pagee").append("当前页："+this.currCount+"/"+this.totalPages+
							"</a>&nbsp;<a href='#' onclick='main("+1+","+this.pageSize+
							")'>首页</a><a href='#' onclick='main("+(this.currCount-1)+","+this.pageSize+
							")'>上一页</a><a href='#' onclick='main("+(this.currCount+1)+","+this.pageSize+
							")'>下一页</a><a href='#' onclick='main("+this.totalPages+","+this.pageSize+
							")'>尾页</a>");
				});
			},
			error:function(){
				alert("异常");
			}
		});
};

//添加主题
$(function(){
	$("#tjz").click(function(){
		$("#center").html("");
		$("#center").append("<h2>添加主题</h2><input type='text' id='name'/><br><input type='button' onclick='tian()' value='添加' ><input type='button' value='返回'onclick='back()'>");
	});
	
});
function tian(){
	var to=$("#name").val();
	//alert(to);
//	$.get("add",["name="+to],function(data){
//		alert(data);
//	});	
	$.ajax({
		url:"add",
		type:"post",
		data:"name="+to,
		dataType:"text",
		success:function(data){
			//alert(data);
			if(data=true){
				alert("添加成功！");
				$("#name").val("");
			}
		},
		error:function(){
			alert("异常");
		},
	});
};
function back(){
	main();
}

/*//添加点击事件--用id不可以
$(function(){
	$("#a").click(function(){
		alert("jin");
		var topic=$("#name").val(); 
		alert(topic);
		$.get("add?name="+topic,function(data){
			
		});	
	});
});*/

//编辑主题
$(function(){
	$("#xgz").click(function(){
		$("#center").html("");
		$.get("main",function(data){
			data=JSON.parse(data);
			$("#center").append("<h2>编辑主题</h2>");
			//var ji=1;
			$(data).each(function(){
				$("#center").append("<span id='zhuti'>"+this.topic+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"<input type='button' value='修改' onclick='update("+this.sid+")'><input type='button' value='删除'onclick='deletee("+this.sid+")'><br>");
			});
			$("#center").append("<input type='button' value='返回'onclick='back()'>");
		});
	});
});
function update(id){
	//var topic=$("span").text();
	//var topic = document.getElementById("zhuti").innerText;
	alert(topic);
	var sid=id;
	$("#center").html("");
	$("#center").append("<input type='text' id='too'/><br>"+
			"<input type='button' value='确定' onclick='xiugai("+sid+")'><input type='button' value='返回' onclick='back1()'> ");

}
function deletee(id){
	//alert(id);
	$.ajax({
		url:"delete",
		type:"post",
		data:"sid="+id,
		dataType:"text",
		success:function(data){
			if(data=true){
				alert("删除成功！");
				$("#center").html("");
				$.get("main",function(data){
					data=JSON.parse(data);
					$("#center").append("<h2>编辑主题</h2>");
					$(data).each(function(){
						$("#center").append("<span id='zhuti'>"+this.topic+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"<input type='button' value='修改' onclick='update("+this.sid+")'><input type='button' value='删除'onclick='deletee("+this.sid+")'><br>");
					});
					$("#center").append("<input type='button' value='返回'onclick='back()'>");
				});
			}else{
				alert("删除失败！");
			}
		},
		error:function(){
			alert("异常");
		},
	});
}
function xiugai(sid){
	//alert(sid);
	var topic=$("#too").val();
	//alert(topic);
	$.ajax({
	url:"update",
	type:"post",
	data:"sid="+sid+"&topic="+topic ,
	dataType:"text",
	success:function(data){
		if(data=true){
			alert("修改成功！");
		}else{
			alert("修改失败！");
		}
	},
	error:function(){
		alert("异常");
	},
});
}
function back1(){
	$("#center").html("");
	$.get("main",function(data){
		data=JSON.parse(data);
		$("#center").append("<h2>编辑主题</h2>");
		$(data).each(function(){
			$("#center").append("<span id='zhuti'>"+this.topic+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
			"<input type='button' value='修改' onclick='update("+this.sid+")'><input type='button' value='删除' onclick='delete("+this.sid+")'><br>");
		});
		$("#center").append("<input type='button' value='返回'onclick='back()'>");
	});
}
//添加新闻
$(function(){
	$("#tjx").click(function(){
		$("#center").html("");
		$.get("main",function(data){
			data=JSON.parse(data);//需要转换
			
			$("#center").append("<h2>添加新闻</h2>");
			$("#center").append("<select id='se'>");
			$(data).each(function(){
				$("#se").append("<option value='"+this.sid+"'>"+this.topic+"</option>");
			});
			$("#center").append("</select><br>");
			$("#center").append("新闻：<input type='text' id='news'/><br>"+
					"作者：<input type='text' id='author'/><br>"+
					"<input type='button' value='添加'onclick='add()' id='ad'><input type='button' value='返回'onclick='back()'>");
		});
		
	});
});

//添加新闻
function add(){
	var topic=$("#se").val();
	var news=$("#news").val();
	var author=$("#author").val();
	if(news==null&&news==""){
		alert("新闻不能为空");
	}else if(author==null&&author==""){
		alert("作者不能为空");
	}
	$.ajax({
		url:"add",
		type:"post",
		data:"news="+news+"&author="+author+"&topic="+topic,
		dataType:"text",
		success:function(data){
			//alert(data);
			if(data=true){
				alert("添加成功！");
				$("#news").val("");
				$("#author").val("");
				//main();
			}else{
				alert("添加失败！");
			}
		},
		error:function(){
			alert("异常");
		},
	});
}
//编辑新闻
$(function (){
	$("#xgx").click(function(){
		$("#center").html("");
		$.get("main?currPage=1&pageSize=5",function(data){
			data=JSON.parse(data);//需要转换
			
			$("#center").append("<h2>编辑新闻</h2>");
			$(data.list).each(function(){
				$("#center").append("主题是："+this.topic+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"新闻内容："+this.news+
						"&nbsp;&nbsp;&nbsp;&nbsp;作者："+this.author+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='xi("+this.cid+
						")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='deleteone("+this.cid+")'>删除</a><br>");
			});
			$("#center").append("<input type='button' value='返回' onclick='back()'>");
			});
	});
});

//修改新闻
function xi(s_sid){
	$("#center").html("");
	$.get("main",function(data){
		data=JSON.parse(data);//需要转换
		
		$("#center").append("<h2>修改新闻</h2>");
		$("#center").append("<select id='se'>");
		$(data).each(function(){
			$("#se").append("<option value='"+this.sid+"'>"+this.topic+"</option>");
		});
		$("#center").append("</select><br>");
		$("#center").append("新闻：<input type='text' id='news'/><br>"+
				"作者：<input type='text' id='author'/><br>"+
				"<input type='button' value='确定' onclick='updateone("+s_sid+")'><input type='button' value='返回'onclick='backo()'>");
	});
};
function updateone(id){
	alert(id);
	var sid=$("#se").val();
	alert(sid);
	var news=$("#news").val();
	var author=$("#author").val();
	if(news==null&&news==""){
		alert("新闻不能为空");
	}else if(author==null&&author==""){
		alert("作者不能为空");
	}
	$.ajax({
		url:"update",
		type:"post",
		data:"news="+news+"&author="+author+"&sid="+sid+"&cid="+id,
		dataType:"text",
		success:function(data){
			//alert(data);
			if(data=true){
				alert("修改成功！");
				$("#news").val("");
				$("#author").val("");
				//main();
			}else{
				alert("修改失败！");
			}
		},
		error:function(){
			alert("异常");
		},
	});
}
function backo(){
	$("#center").html("");
	$.get("main?currPage=1&pageSize=5",function(data){
		data=JSON.parse(data);//需要转换
		
		$("#center").append("<h2>编辑新闻</h2>");
		$(data.list).each(function(){
			$("#center").append("主题是："+this.topic+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"新闻内容："+this.news+
					"&nbsp;&nbsp;&nbsp;&nbsp;作者："+this.author+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='xi()'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' >删除</a><br>");
		});
		$("#center").append("<input type='button' value='返回' onclick='back()'>");
		});
}
function deleteone(id){
	//alert(id);
	$.ajax({
		url:"delete",
		type:"post",
		data:"cid="+id,
		dataType:"text",
		success:function(data){
			if(data=true){
				alert("删除成功！");
				$("#center").html("");
				$.get("main?currPage=1&pageSize=5",function(data){
					data=JSON.parse(data);//需要转换
					
					$("#center").append("<h2>编辑新闻</h2>");
					$(data.list).each(function(){
						$("#center").append("主题是："+this.topic+
								"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"新闻内容："+this.news+
								"&nbsp;&nbsp;&nbsp;&nbsp;作者："+this.author+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='xi("+this.cid+
								")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='deleteone("+this.cid+")'>删除</a><br>");
					});
					$("#center").append("<input type='button' value='返回' onclick='back()'>");
					});
			}else{
				alert("删除失败！");
			}
		},
		error:function(){
			alert("异常");
		},
	});
}