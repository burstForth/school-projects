<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
   <%  String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>/BackEnd/assets/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=basePath%>/BackEnd/assets/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">管理员管理</a>
        <a href=""><cite>权限管理</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <xblock>
<!--         <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
 -->        <span class="x-right" style="line-height:40px">共有数据：${p.totalnumber} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>权限规则</th>
            <th>权限名称</th>
            <th>所属分类</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="m">
          <tr>
            <td>${m.mid}</td>
            <td>${m.url}</td>
            <td>${m.mname}</td>
            <td>${m.type}</td>
            <td class="td-manage">
           <shiro:hasPermission name="rule:update">
              <a title="编辑"  onclick="x_admin_show('编辑','xxx.html')" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>
              </shiro:hasPermission>
             <shiro:hasPermission name="rule:delete">
              <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
              </shiro:hasPermission>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
       <c:if test="${p.currpage!=1}"> 
          <a class="prev" href="javascript:chaxun('${p.currpage-1}','${p.rows}');">&lt;&lt;</a>
          <a class="prev" href="javascript:chaxun('1','${p.rows}');">首页</a>
	       </c:if> 
           <a   href="javascript:chaxun('${p.currpage}','${p.rows}');"   class="num" style="background-color:#008B8B;color: white;">${p.currpage}</a>
          <c:if test="${p.currpage!=p.totalpage}">
             <a class="next" href="javascript:chaxun('${p.totalpage}','${p.rows}');">尾页</a>
          <a class="next" href="javascript:chaxun('${p.currpage+1}','${p.rows}');">&gt;&gt;</a>
          </c:if> 
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;

        
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();
    </script>
     <script type="text/javascript">
    function chaxun(currpage,rows){
       window.location="/HouseCms/menu/findall?currpage="+currpage+"&rows="+rows;
    }
    </script>
  </body>

</html>