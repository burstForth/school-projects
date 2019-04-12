<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/FrontEnd/assets/css/isotope.css" media="screen" />
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/style.css">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
		#left img{
			width:283px;
			height:216px;
		}
		#main{
		
			padding-top:40px;
			width:1100px;
			height:auto;
			margin:0 auto;
		}
		#cen{
         height:250px;
      	width:1100px;
		margin-top:20px;
		}
		#left{
		float:left;
		width:340px;
		height:276px;
		}
		#right{
		padding-top:5%;
		width:60%;
		margin-right:8%;
		height:276px;
		float:right;
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
				<a class="navbar-brand" href="index.html">
					<img src="<%=basePath%>/FrontEnd/assets/images/logo.png" alt="Techro HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li ><a href="/HouseCms/news/findByPage">网站首页</a></li>
					<li><a href="/HouseCms/FrontEnd/price.jsp">公司简介</a></li>
					<li><a href="/HouseCms/news/newfindByPage">新闻动态</a></li>
					<li class="active"><a href="/HouseCms/project/findall">项目展示</a></li>
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
					<h1>项目展示</h1>
				</div>
			</div>
		</div>
	</header>
<div id="main">
<c:forEach  items="${plist}" var="m">
	<div id="cen">
		<div id="left">
			<img src="/HouseCms/${m.url}"  alt="" />
		</div>
		<div id="right">
		<strong> ${m.pname }</strong>
		<div style="height: 150px;width: 700px;"> ${fn:substring (m.pdescribe,0,260)}  </div>
		</div>
	</div>
</c:forEach>
</div>
		<footer id="footer" style="clear: both;"> 
		<div class="footer2" style="clear: both;">
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
	<script src="<%=basePath%>/FrontEnd/assets/js/jquery.cslider.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/jquery.isotope.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/custom.js"></script>
	<script type="text/javascript">
    function fun(ptid){
       window.location="/HouseCms/project/findall?ptid="+ptid;
    }
    </script>
</body>
</html>