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
        <a href="">新闻管理</a>
        <a>
          <cite>行业动态</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <xblock>
       <shiro:hasPermission name="dt:delete">
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
       </shiro:hasPermission>
         <shiro:hasPermission name="dt:add">
        <button class="layui-btn" onclick="x_admin_show('添加品牌','<%=basePath%>BackEnd/jsp/order-add.jsp')"><i class="layui-icon"></i>添加</button>
        </shiro:hasPermission>
        <span class="x-right" style="line-height:40px">共有数据: ${p.totalnumber } 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <input type="checkbox"  name="box" id="selectAll" class="layui-unselect header layui-form-checkbox" lay-skin="primary"/>
            </th>
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>新闻名称</th>
            <th>发布时间</th>
            <th>作者</th>
            <th>状态</th>
            <th >操作</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach items="${lists}" var="m">
          <tr>
            <td>
           <input type="checkbox" value="${m.nid}"   name="newsCheck"  class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'/>
            </td>
            <input type="hidden" value="${m.ntype}" id="ntype" name="ntype"/>
            <td>${m.nid}</td>
            <td>${m.nname}</td>
            <td>${fn:substring(m.ntitle,0,20)}...</td>
            <td>${m.create_time}</td>
            <td>${m.uname}</td>
           <td class="td-status">
               <c:if test="${m.nstatus=='2'}">
            <span class="layui-btn layui-btn-normal layui-btn-mini
              layui-btn-disabled ">已停用
               </span>
              </c:if>
             <c:if test="${m.nstatus=='1'}">
            <span class="layui-btn layui-btn-normal layui-btn-mini">已启用
               </span>
              </c:if>
              </td>
            <td class="td-manage">
              <shiro:hasPermission name="dt:stastu">
            <a onclick="member_stop(this,'${m.nstatus}','${m.nid}')" href="javascript:;"  title="启用">
                <c:if test="${m.nstatus==2}">
                <i class="layui-icon ">&#xe62f;</i>
                </c:if>
                 <c:if test="${m.nstatus==1}">
                <i class="layui-icon ">&#xe601;</i>
                </c:if>
              </a>
              </shiro:hasPermission>
                <shiro:hasPermission name="dt:select">
              <a title="查看"  onclick="x_admin_show('编辑'  , '/HouseCms/news/findids?id=${m.nid}')" href="javascript:;">
                <i class="layui-icon">&#xe63c;</i>
              </a>
                </shiro:hasPermission>
                  <shiro:hasPermission name="dt:delete">
              <a title="删除" onclick="member_del(this,'${m.nid }')" href="javascript:;">
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
      function member_stop(obj,status,id){
    	  if(status==1){
          layer.confirm('确认要停用吗？',function(index){
                //发异步把用户状态进行更改
                $.ajax({
      			data: {"nstatus":status,
      					"nid":id},
      			type: 'POST',
      			url: '/HouseCms/news/status1',
      			dataType: 'json',
      			success: function(data){
      			},
      			error:function(data) {
      			},
      		});	
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');
                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});
                location.replace(location.href);
          });    
          }else{
        	  layer.confirm('确认要启用吗？',function(index){
                $(obj).attr('title','启用')
                //发异步把用户状态进行更改
                  $.ajax({
        			data: {"nstatus":status,
        					"nid":id},
        			type: 'POST',
        			url: '/HouseCms/news/status1',
        			dataType: 'json',
        			success: function(data){
        			},
        			error:function(data) {
        			},
        		});	
                $(obj).find('i').html('&#xe601;');
                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
                location.replace(location.href);
          });
      }
      }
      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
        	  //发异步删除数据
      		$.ajax({
      			data: {"id":id},
      			type: 'POST',
      			url: '/HouseCms/news/delete1',
      			dataType: 'json',
      			success: function(data){
      				$(obj).parents("tr").remove();
      				layer.msg('已删除!',{icon:1,time:1000});
      			},
      			error:function(data) {
      				console.log(data.msg);
      			},
      		});	
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll () {
    	  var checkedNum = $("input[name='newsCheck']:checked").length;
  	    if (checkedNum == 0) {
  	        layer.confirm('至少选择一条！');
  	        return;
  	    }
        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
        var newsList = new Array();
        $("input[name='newsCheck']:checked").each(function(){
        	newsList.push($(this).val());
        });
	    $.ajax({
            type : "post",
            url : "/HouseCms/news/batchDelete1",
            data : {newslist : newsList.toString()},
            success : function(){
            	 layer.msg('删除成功', {icon: 1});
                 window.location.reload();
                //$('#myform').submit();
            },
            error : function(){
            	 layer.msg('删除失败', {icon: 1});
            }
	    });
        });
      }
    </script>
          <script type="text/javascript">
      function chaxun(currpage,rows){
    	  var ntype=document.getElementById("ntype").value;
         window.location="/HouseCms/news/newfindByPagess?currpage="+currpage+"&rows="+rows+"&ntype="+ntype;
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
     $(function(){
    	$("#selectAll").bind("click",function(){ 
    		if($(this).prop("checked")){
    			$("input[type='checkbox']").not(this).prop("checked",true);
    	   }else{
    		    $("input[type='checkbox']").not(this).prop("checked",false); 
    		
    	   }
        }); 
    	

    	$("input[name='newsCheck']").click(function() {
			var a=0;
			var box=document.getElementsByName("newsCheck");
			var b=document.getElementById("selectAll");
			$("input[name='newsCheck']").each(function(i,e) {
				if (box[i].checked) {
					a++;
				}
				if (box.length==a) {
					b.checked=true;
				}
				if (box.length!=a) {
					b.checked=false;
				}
			})
		})
    	
    }); 
     
</script>
  </body>

</html>