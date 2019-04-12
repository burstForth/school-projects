<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
   <%  String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>后台登录-X-admin2.1</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/font.css">
	<link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
    <script src="<%=basePath%>/BackEnd/assets/lib/layui/layui.js" charset="utf-8"></script>

    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/cookie.js"></script>
    <script>
        // 是否开启刷新记忆tab功能
        // var is_remember = false;
    </script>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="<%=basePath%>/BackEnd/jsp/index.jsp">Back-stage management</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
           
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('资讯','https://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
              <dd><a onclick="x_admin_show('图片','https://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
               <dd><a onclick="x_admin_show('用户','https://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
               <dd><a onclick="x_admin_add_to_tab('在tab打开','https://www.baidu.com',true)"><i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
            </dl>
          </li>
        </ul>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">${user.uname}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('切换帐号','../BackEnd/jsp/login.jsp')">切换帐号</a></dd>
              <dd><a href="<%=basePath%>/BackEnd/jsp/login.jsp">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="/HouseCms/news/findByPage">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        <c:forEach items="${list}" var="m">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">
                    <c:choose> 
                            <c:when test="${m.mname eq '管理员管理'}">&#xe726;</c:when>
                            <c:when test="${m.mname eq '图片管理'}">&#xe70b;</c:when>
                            <c:when test="${m.mname eq '品牌管理'}">&#xe723;</c:when>
                            <c:when test="${m.mname eq '项目管理'}">&#xe6ce;</c:when>
                            <c:when test="${m.mname eq '新闻管理'}">&#xe6b4;</c:when>
                       </c:choose>
                    </i>
                    <cite>${m.mname}</cite>
                </a>
              
                <ul class="sub-menu">
                 <c:forEach items="${listmenu}" var="ml">
               <c:if test="${ml.type!=menu1 && ml.parene_id==m.mid}">
                  <li>
                        <a _href="${ml.url}">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>${ml.mname}</cite>
                        </a>
                  
                    </li >
                     </c:if>
                 </c:forEach>
                  </ul>
               
               
            </li>
              </c:forEach>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                <dl>
                    <dd data-type="this">关闭当前</dd>
                    <dd data-type="other">关闭其它</dd>
                    <dd data-type="all">关闭全部</dd>
                </dl>
          </div>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/HouseCms/user/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
          <div id="tab_show"></div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Copyright ©2019 x-admin v2.3 All Rights Reserved</div>  
    </div>
</body>
</html>