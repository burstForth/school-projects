<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%  String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Real Estate Builders Free Responsive Website Templates - icon">
	<meta name="author" content="">
	<title></title>
	<link rel="favicon" href="<%=basePath%>/FrontEnd/assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/font-awesome.min.css">
	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/bootstrap-theme.css" media="screen">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/style.css">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/service.css">
	<style type="text/css">
	#tname{
	width:200px;
	height:30px;
	margin: auto;
	margin-top: 20px;
	font-size: 16px;
	}
	#time{
	
	width:620px;
	height:30px;
	margin: auto;
	}
	#time li{
	float:left;
	width:300px;
	height:30px;
	margin-top: 30px
	}
	#ttitle{
    clear: both;
	width:1000px;
	height:auto;
	margin: auto;
	}
	#tcontcet{
	width:1000px;
	height:auto;
	margin: auto;
	}
	</style>
</head>
<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
				<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
				<a class="navbar-brand" href="login.jsp">
					<img src="<%=basePath%>/FrontEnd/assets/images/logo.png" alt="Techro HTML5 template"></a>
			</div>
			 <div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li ><a href="/HouseCms/news/findByPage">网站首页</a></li>
					<li><a href="/HouseCms/FrontEnd/price.jsp">公司简介</a></li>
					<li class="active"><a href="/HouseCms/news/newfindByPage">新闻动态</a></li>
					<li><a href="/HouseCms/project/findall">项目展示</a></li>
					<li><a href="/HouseCms/brand/findByPage">品牌建设</a></li>
					<li><a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a></li>
						</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->

	<header id="head" class="secondary">
		<div class="container">
			<div class="row">
				<div class="col-sm-8">
					<h1>新闻动态</h1>
				</div>
			</div>
		</div>
	</header>
	
	<div id="courses" style="width: 1000px;height: auto;">
		<div id="tname" ><strong>${news.nname}</strong></div>
		<ul id="time">
		<li>作者：${news.uname}</li>
		<li>发布时间：${news.create_time}</li>
		</ul>
		<div id="ttitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>${news.ntitle}</strong></div>
		<div id="tcontcet">${news.ncontent}</div>
	</div>

		<footer id="footer"> 
		<div class="footer2">
			<div class="container">
				<div class="row">

					<div class="col-md-6 panel">
						<div class="panel-body">
							<p class="simplenav">
								<a href="/HouseCms/news/findByPage">网站首页</a>|
								<a href="/HouseCms/FrontEnd/price.jsp">公司简介</a>|
								<a href="/HouseCms/news/newfindByPage">新闻动态</a>|
								<a href="/HouseCms/project/findall">项目展示</a>|
								<a href="/HouseCms/brand/findByPage">品牌建设</a>|
							    <a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a>
							</p>
						</div>
					</div>

					<div class="col-md-6 panel">
						<div class="panel-body">
							<p class="text-right">
							 <a href="" target="_blank" title="模板之家">昌建房地产有限责任公司</a> - Collect from 
							</p>
						</div>
					</div>

				</div>
				<!-- /row of panels -->
			</div>
		</div>
	</footer>




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>/FrontEnd/assets/js/jquery.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/custom.js"></script>
</body>
</html>