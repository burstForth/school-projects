<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%  String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Real Estate Builders Free Responsive Website Templates - icon">
	<meta name="author" content="">
	<title>Home</title>
	<link rel="favicon" href="<%=basePath%>/FrontEnd/assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/bootstrap-theme.css" media="screen"> 
	<link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/style.css">
    <link rel='stylesheet' id='camera-css'  href='<%=basePath%>/FrontEnd/assets/css/camera.css' type='text/css' media='all'> 
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
					<li class="active"><a href="/HouseCms/news/findByPage">网站首页</a></li>
					<li><a href="/HouseCms/FrontEnd/price.jsp">公司简介</a></li>
					<li><a href="/HouseCms/news/newfindByPage">新闻动态</a></li>
					<li><a href="/HouseCms/project/findall">项目展示</a></li>
					<li><a href="/HouseCms/brand/findByPage">品牌建设</a></li>
					<li><a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->

	<!-- Header -->
	<header id="head">
		<div class="container">
					<div class="fluid_container">
                    <div class="camera_wrap camera_emboss pattern_1" id="camera_wrap_4">
                    <c:forEach items="${ilist}" var="i">
                        <div data-thumb="/HouseCms/${i.url}" data-src="/HouseCms/${i.url}">
                        </div> 
                        </c:forEach>
                       
                    </div><!-- #camera_wrap_3 -->
                </div><!-- .fluid_container -->
		</div>
	</header>
	<!-- /Header -->

      <section class="secpadding">
	  <div class="container">
      <div class="row">
    
        </div>
		<span></span>
		</div>

		</section>
      <section class="news-box secpadding">
        <div class="container">
            
            <h2><span><center>当前项目</center></span></h2>
            <div class="row">
            	
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="<%=basePath%>/FrontEnd/assets/images/imgindex/3d3s.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                                <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>精品住宅</strong></p>
                                            <p>The quality of resjdentia </p>
                                        </div>
                                        <div>
                                            <a href="#" class="btn-inline">more</a>
                                        </div>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="<%=basePath%>/FrontEnd/assets/images/imgindex/s06l.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                            <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>商务办公</strong></p>
                                            <p>Business office</p>
                                        </div>
                                        <div>
                                            <a href="#" class="btn-inline">more</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="<%=basePath%>/FrontEnd/assets/images/imgindex/sdux.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                            <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>高端休闲</strong></p>
                                            <p>The high-end leisure</p>
                                        </div>
                                        <div>
                                            <a href="#" class="btn-inline">more</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="<%=basePath%>/FrontEnd/assets/images/imgindex/ju8a.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                           <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>五星酒店</strong></p>
                                            <p>The five-star hotel </p>
                                        </div>
                                        <div>
                                            <a href="#" class="btn-inline">more</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
   
  <section id="packages" class="secpadding">
        <div class="container">
             <h2><span><center>项目展示</center></span></h2>
            <div class="row">
                  <c:forEach items="${plist}" var="p">
                <div class="col-md-3 col-sm-6" >
                
                            <div class="cuadro_intro_hover " style="background-color:#cccccc;">
                         
                                <p style="text-align:center;">
                                    <img src="/HouseCms/${p.url}" class="img-responsive" alt="">
                                </p>
                                <div class="caption" >
                                    <div class="blur"></div>
                                    <div class="caption-text">
                                         <h3> ${p.pname}</h3> 
                                    </div>
                                </div>
                                
                              </div>
                        
                </div>
            
                 </c:forEach>   
            </div>    
         </div>
    </section>
	
      
      
    	 
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
	<script src="<%=basePath%>/FrontEnd/assets/js/modernizr-latest.js"></script> 
	<script type='text/javascript' src='<%=basePath%>/FrontEnd/assets/js/jquery.min.js'></script>
    <script type='text/javascript' src='<%=basePath%>/FrontEnd/assets/js/fancybox/jquery.fancybox.pack.js'></script>
    <script type='text/javascript' src='<%=basePath%>/FrontEnd/assets/js/jquery.mobile.customized.min.js'></script>
    <script type='text/javascript' src='<%=basePath%>/FrontEnd/assets/js/jquery.easing.1.3.js'></script> 
    <script type='text/javascript' src='<%=basePath%>/FrontEnd/assets/js/camera.min.js'></script> 
    <script src="<%=basePath%>/FrontEnd/assets/js/bootstrap.min.js"></script> 
	<script src="<%=basePath%>/FrontEnd/assets/js/custom.js"></script>
	
	
	
    <script>
		jQuery(function(){
			
			jQuery('#camera_wrap_4').camera({
				height: '750',
				loader: 'bar',
				pagination: false,
				thumbnails: false,
				hover: false,
				opacityOnGrid: false,
				imagePath: 'assets/images/'
			});

		});
		var oBox = document.getElementById("box");
    var aBtn = oBox.getElementsByTagName("input");
    var aDiv = oBox.getElementsByTagName("div");
    //aBtn是一组元素，所以需要用到for循环
    for(var i=0;i<aBtn.length;i++){
        aBtn[i].index=i;
        aBtn[i].onclick=function(){
            for(var k=0;k<aBtn.length;k++){//先清空所有的样式
                aBtn[k].className ='';
                aDiv[k].style.display ='none';
            }
            //给当前的按钮和div添加样式
            this.className ='on';
            aDiv[this.index].style.display ='block';
        };
    }
	</script>
    
</body>
</html>
