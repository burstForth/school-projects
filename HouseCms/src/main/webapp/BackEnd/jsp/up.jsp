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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
 <link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/cookie.js"></script>
<!--[if IE 6]>/BackEnd/assets/h-ui.admin/css/style.css
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新建网站角色 - 管理员管理 - H-ui.admin v3.1</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
    <div class="x-body">
        <form class="layui-form" id="myform" action="/HouseCms/img/add" enctype="multipart/form-data" method="post">
          <div class="layui-form-item"  style="margin-left: 300px;margin-top: 100px">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>您要添加的图片
              </label>
              <div class="layui-input-inline">
                   <input  type="file" id="username" name="file" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" >
              </div>
          </div>
          <div class="layui-form-item" style="margin-left: 300px;">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="add" > 增加</button>
          </div>
      </form>
    </div>
    <script>
    layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;

          //监听提交
          form.on('submit(add)', function(data){
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
            	
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
                // 可以对父窗口进行刷新
                x_admin_father_reload();
             
                	$("#myform").submit();
              
            });
            return false;
        	 
          });
          
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();
    </script>
    <script type="text/javascript">
    $(function() {
		$("#username").blur(function() {
			var name=$("#username").val();
			if(''!=name){
				$.ajax({
        			data: {"name":name},
        			type: 'POST',
        			url: '/HouseCms/user/findname',
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
</html>