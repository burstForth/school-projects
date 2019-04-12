<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
   <%  String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/BackEnd/assets/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/BackEnd/assets/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/BackEnd/assets/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/BackEnd/assets/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/BackEnd/assets/h-ui.admin/css/style.css" />
<title>新建网站角色 - 管理员管理 - H-ui.admin v3.1</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="/HouseCms/role/add" method="post" class="form form-horizontal" id="myform" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="rolename" name="rname">
			    <span id="span"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">网站角色：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<c:forEach items="${list}" var="m">
				<dl class="permission-list">
					<dt>
						<c:if test="${m.type=='menu1'}">
							<input type="checkbox" value="${m.mid}"  name="mid" id="user-Character-0">
							${m.mname}
							</c:if>
					</dt>
					<dd>
					<c:forEach items="${listmenu}" var="ml">
					
						<dl class="cl permission-list2">
							<dt>
								<c:if test="${m.mid==ml.parene_id && ml.type=='menu'}">
									<input type="checkbox" value="${ml.mid}" name="mid" id="user-Character-0-0">
									${ml.mname}
									</c:if>
							</dt>
							<dd>
							<c:forEach items="${listbutton}" var="lb">  
							<c:if test="${m.mid==ml.parene_id && ml.type=='menu' && ml.mid==lb.parene_id && lb.type=='button'}">
									<input type="checkbox" value="${lb.mid}" name="mid" id="user-Character-0-0-0">
									${lb.mname}
									</c:if>
									</c:forEach>
							</dd>
						</dl>
					
					</c:forEach>
					</dd>
				</dl>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button  class="btn btn-success radius" id="admin-role-save" name="admin-role-save"  lay-filter="add" lay-submit="add"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript">
$(function(){
	$(".permission-list dt input:checkbox").click(function(){
		$(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
	});
	$(".permission-list2 dd input:checkbox").click(function(){
		var l =$(this).parent().parent().find("input:checked").length;
		var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
		if($(this).prop("checked")){
			$(this).closest("dl").find("dt input:checkbox").prop("checked",true);
			$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
		}
		else{
			if(l==0){
				$(this).closest("dl").find("dt input:checkbox").prop("checked",false);
			}
			if(l2==0){
				$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
			}
		}
	});
	$(".permission-list2  input:checkbox").click(function(){
		var l =$(this).parent().parent().find("input:checked").length;
		var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
		if($(this).prop("checked")){
			$(this).closest("dl").find("dt input:checkbox").prop("checked",true);
			$(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
		}
		else{
			if(l==0){
				$(this).closest("dl").find("dt input:checkbox").prop("checked",false);
			}
			if(l2==0){
				$(this).parents(".permission-list").find("dt").find("input:checkbox").prop("checked",false);
			}
		}
	});
	 $("#myform").validate({
		rules:{
			rname:{
				required:true
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			if($("#span").html()==''){
			/* layer.alert("增加成功", {icon: 6});  */
			var index = parent.layer.getFrameIndex(window.name);
			
			parent.layer.close(index);
			
			x_admin_father_reload();
				 
			 $("#myform").submit(); 
				
		}else{
			/*  layer.alert("增加失败", {icon: 6}); */
			alert("增加失败")
            var index = parent.layer.getFrameIndex(window.name);
			
			parent.layer.close(index);
			
			x_admin_father_reload();
		}
		}
	});
});

</script>
 <script type="text/javascript">
    $(function() {
		$("#rolename").blur(function() {
			var name=$("#rolename").val();
			if(''!=name){
				$.ajax({
        			data: {"name":name},
        			type: 'POST',
        			url: '/HouseCms/role/findname',
        			dataType: 'json',
        			success: function(data){
        				if(data.message){
        			$("#span").html("<font color='red'>用户名已存在</font>")
        				}else{
        					$("#span").html("")
        				}
        			},
        			error:function(data) {
        				
        			},
        		});	
				
			}
		})
		
	})
    
    </script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>