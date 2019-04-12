<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
				<a class="navbar-brand" href="index.html">
					<img src="<%=basePath%>/FrontEnd/assets/images/logo.png" alt="Techro HTML5 template"></a>
			</div>
			 <div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li ><a href="/HouseCms/news/findByPage">网站首页</a></li>
					<li><a href="/HouseCms/FrontEnd/price.jsp">公司简介</a></li>
					<li><a href="/HouseCms/news/newfindByPage">新闻动态</a></li>
					<li><a href="/HouseCms/project/findall">项目展示</a></li>
					<li><a href="/HouseCms/brand/findByPage">品牌建设</a></li>
					<li class="active"><a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a></li>
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
					<h1>Contact us</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- container -->
	<div class="container">
				<div class="row" style="margin-top: 50px;">
					<div class="col-md-6">
					<div style="margin-bottom: 20px">
						<strong>公司地址</strong>
						</div>
						<iframe align="center" width="100%" height="300px" src="map.jsp"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-6">
								<h3 class="section-title">办公地址</h3>
								<div class="contact-info">
									<h5>地址</h5>
									<p>郑州郑东新区金水东路88号楷林IFC-D座10F</p>
									
									<h5>Email</h5>
									<p>cjdcxz@hncj.com.cn</p>
									<h5>Phone</h5>
									<p>0371-86092666</p>
								</div>
							</div>
							<div class="col-md-6">
								<h3 class="section-title">上班时间</h3>
								<div class="contact-info">
									<h5>周一 - 周五</h5>
									<p>09:00 AM - 6:30 PM</p>
									
									<h5>周六</h5>
									<p>Closed</p>
									
									<h5>周日</h5>
									<p>Closed</p>
								</div>
							</div>
						</div>
						<h3 class="section-title">Get connected</h3>
						<p>
						Lorem ipsumn qersl ioinm sersoe non urna dolor sit amet, consectetur piesn qersl ioinm sersoe non urna dolor aecena.
						</p>						
					</div>
				</div>
			</div>
	<!-- /container -->

	

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

	<!-- Google Maps -->
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/google-map.js"></script>


</body>
</html>