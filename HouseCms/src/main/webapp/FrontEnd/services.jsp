<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<style type="text/css">
		#main{
			float:left;
			margin:0px auto;
			margin-top:1%;
			height:80%;
			width:60%;
			margin-left:5%;
			/* border:1px solid black;  */
		}
		#left{
		float:left;
		width:20%;
		}
		#top{
		margin-top:100%;
		height:60px;
		padding-top:20px;
		
		}
		#mid{
		margin-top:10%;
		padding-top:20px;
		height:60px;
		
		}
		#center{
		margin-top:5%;
		float:left;
		margin-left:2%;
		width:50%;

		}
		.button{
		 width: 150px;
		 height: 50px;
		 font-size: 16px;
		 /* color: #fff; */
		 color: black; 
		 /* background: #36648B; */
		 background: white;
		 border-radius: 5px;
		}
		#footer{
		padding-top:20px;
		float:left;
		width:100%;
		height:60px;
		margin-top:7%;
	 	background:#030E3C;
		}
		#panel-body{
		float:left;
		margin-left:15%;
		}
		#panel-body a{
		margin-left:5px;
		}
		#ri{
		float:right;
		margin-right:20%;
		}
		#right{
		border:1px solid black;
		margin-top:20%;
		float:right;
		width:202px;
		height:263px;
		margin-right:-45%;
		}
		#top a{
		border-radius:28px;
		padding-top:13px;
		display:block;
		font-size:20px;
		width:150px;
		height:60px;
		text-decoration:none;
		}
		#mid a{
		padding-top:13px;
		width:150px;
		height:60px;
		border-radius:28px;
		display:block;
		font-size:20px;
		text-decoration:none;
		}
		#top a:hover{background-color:#36648B;color:#fff;}
		#mid a:hover{background-color:#36648B;color:#fff;}
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
	
<div id="main">
	<div id="left">
		<div id="top" align="center">
			 <a href="/HouseCms/news/newfindByPage?ntype=1" id="go">公司新闻</a>
		</div>
		<div id="mid" align="center">
			 <a href="/HouseCms/news/newfindByPage?ntype=2" style="margin-bottom: 20px">行业动态</a>
		</div>
	</div>
	<div id="center">
		<c:forEach items="${list}" var="n">
       <input type="hidden" value="${n.ntype}" id="ntype" name="ntype"/>
               <li style=";width: 800px;height: 100px;margin-bottom: 20px">
                <a href="/HouseCms/news/findid?id=${n.nid}"><strong>${n.nname}</strong><div style="float: right;width: 100px;height:30px;color: black;">${n.create_time}</div></a>
                <br/><br/><p>${n.ntitle}<br/>
                ${fn:substring(n.ncontent,0,50)}...
                </p>
                 </li>
                    <br/>
       </c:forEach>
    
       <div style="margin: auto;">
   当前 ${p.currpage}/${p.totalpage} 页   
    <ul style="float: left;width: 300px;height: 20px;">
     <c:if test="${p.currpage!=1}">
      <li style="float:left;width: 80px;height: 20px;"><a href="javascript:chaxun('${p.currpage-1}','${p.rows}');">上一页</a></li>
     </c:if>
     <c:if test="${p.currpage!=p.totalpage}">
      <li style="float:left; width:80px;height: 20px;"><a href="javascript:chaxun('${p.currpage+1}','${p.rows}');">下一页</a></li>
       </c:if>
    </ul>
  </div>
	</div>
	<div id="right">
		<img src="<%=basePath%>/FrontEnd/assets/images/imgindex/tp_ywep.jpg">
	</div>
</div>
<div id="footer">
	<div id="panel-body">
								<p class="simplenav">
								<a href="/HouseCms/news/findByPage">网站首页</a>&nbsp;&nbsp;&nbsp;|
								<a href="/HouseCms/FrontEnd/price.jsp">公司简介</a>&nbsp;&nbsp;&nbsp;|
								<a href="/HouseCms/news/newfindByPage">新闻动态</a>&nbsp;&nbsp;&nbsp;|
								<a href="/HouseCms/project/findall">项目展示</a>&nbsp;&nbsp;&nbsp;|
								<a href="/HouseCms/brand/findByPage">品牌建设</a>&nbsp;&nbsp;&nbsp;|
							    <a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a>
								</p>
	</div>
					<div id="ri">
						<a id="aaa" href="" target="_blank" title="模板之家">昌建房地产有限责任公司</a> - Collect from 
					</div>		 
							
						
</div>


	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>/FrontEnd/assets/js/jquery-1.8.3.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/jquery.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/FrontEnd/assets/js/custom.js"></script>
	<script type="text/javascript">
    function chaxun(currpage,rows){
    	var ntype=document.getElementById("ntype").value;
      window.location="/HouseCms/news/newfindByPage?currpage="+currpage+"&rows="+rows+"&ntype="+ntype;
    }
    </script>

</body>
</html>