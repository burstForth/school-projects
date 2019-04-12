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
    <link rel="stylesheet" href="<%=basePath%>/FrontEnd/assets/css/style.css">
</head>

<body>
    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <!-- Button for smallest screens -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                <a class="navbar-brand" href="index.jsp">
                    <img src="<%=basePath%>/FrontEnd/assets/images/logo.png" alt="Techro HTML5 template"></a>
            </div>
           <div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li ><a href="/HouseCms/news/findByPage">网站首页</a></li>
					<li><a href="/HouseCms/FrontEnd/price.jsp">公司简介</a></li>
					<li><a href="/HouseCms/news/newfindByPage">新闻动态</a></li>
					<li><a href="/HouseCms/project/findall">项目展示</a></li>
					<li class="active"><a href="/HouseCms/brand/findByPage">品牌建设</a></li>
					<li><a href="/HouseCms/FrontEnd/contact.jsp">联系我们</a></li>
				</ul>
			</div>
            <!--/.nav-collapse -->
        </div>
    </div>
    <!-- /.navbar -->

    <header id="head" class="secondary" style="background-image: ../FrontEnd/assets/images/bg_header.jpg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <h1>品牌展示</h1>
                </div>
            </div>
        </div>
    </header>

    <!-- container -->
    <section class="container" >
        <div class="row">
            <!-- main content -->
            <section class="col-sm-8 maincontent" >
                <h3>品牌理念</h3>
                <c:forEach items="${list}" var="b">
                <div style="margin-top: 10px">
                <div><a href="/HouseCms/brand/findid?id=${b.bid}"><strong>${b.bname}</strong></a></div>
                <div>${b.btitle}</div>
                <div>${fn:substring(b.bcontent,0,500)}</div>
                </div>
               </c:forEach>
 <div style="margin: auto;">
   当前 ${p.currpage}/${p.totalpage} 页   
    <ul style="float: left;width: 300px;height: 20px;">
     <c:if test="${p.currpage!=1}">
      <li style="float: left;width:80px;height: 20px;"><a href="javascript:chaxun('${p.currpage-1}','${p.rows}');">上一页</a></li>
     </c:if>
     <c:if test="${p.currpage!=p.totalpage}">
      <li style="float: left;width:80px;height: 20px;"><a href="javascript:chaxun('${p.currpage+1}','${p.rows}');">下一页</a></li>
       </c:if>
    </ul>
  </div>
           
           </section>
            <!-- /main -->

            <!-- Sidebar -->
            <aside class="col-sm-4 sidebar sidebar-right" >

                <div class="panel">
                    <h4>最新消息</h4>
                    <ul class="list-unstyled list-spaces">
                        <li><a href="">响应式布局</a><br>
                            <span class="small text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, laborum.</span></li>
                        <li><a href="">HTML5, CSS3 and JavaScript</a><br>
                            <span class="small text-muted">Consequuntur eius repellendus eos aliquid molestiae ea laborum ex quibusdam</span></li>
                        <li><a href="">Bootstrap</a><br>
                            <span class="small text-muted">Eveniet, consequuntur eius repellendus eos aliquid molestiae ea</span></li>
                        <li><a href="">Clean Template</a><br>
                            <span class="small text-muted">Sed, mollitia earum debitis est itaque esse reiciendis amet cupiditate.</span></li>
                        <li><a href="">Premium Quality</a><br>
                            <span class="small text-muted">Voluptate minus illo tenetur sint ab in culpa cumque impedit quibusdam. Saepe, molestias quia.</span></li>
                    </ul>
                </div>

            </aside>
            <!-- /Sidebar -->

        </div>
    </section>
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
<form action="/HouseCms/brand/findByPage" id="myform" method="post">
<input type="hidden" name="currpage" value="${p.currpage}">
<input type="hidden" name="rows" value="${p.rows}">
</form>


    <!-- JavaScript libs are placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>/FrontEnd/assets/js/jquery.min.js"></script>
    <script src="<%=basePath%>/FrontEnd/assets/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/FrontEnd/assets/js/custom.js"></script>
    <script type="text/javascript">
    function chaxun(currpage,rows){
       window.location="/HouseCms/brand/findByPage?currpage="+currpage+"&rows="+rows;
    }
    </script>
</body>
</html>