$(document).ready(function(){
	var user={
			"id":1,
			"name":"张三",
			"pwd":"111"
	};
	$("#di").append("id:"+user.id+"<br>")
			.append("用户名:"+user.name+"<br>")
			.append("密码:"+user.pwd+"<br>");
	
	var ary=["中","美","俄"];
	var $ary=$(ary);
	var $ul=$("#ul");
	var $sel=$("#srl");
	$ary.each(function (){
		$ul.append("<li>"+this+"</li>");
	});
	$ary.each(function(i){
		$sel.append("<option value='"+(i+1)+"'>"+this+"</option>");
		
	});
	var userArray=[{
		"id":2,
		"name":"admin",
		"pwd":"123",
	},{
		"id":3,
		"name":"张飞宇",
		"pwd":"123",
	},{
		"id":4,
		"name":"高博",
		"pwd":"123",
	}];
	var $table=$("<table border='1'></table>").append(
			"<tr><td>id</td><td>用户名</td><td>密码</td></tr>");
		$(userArray).each(function(){
			$table.append("<tr><td>"+this.id+"</td><td>"
							+this.name+"</td><td>"
							+this.pwd+"</td></tr>");
		});
		$("#ob").append($table);
});