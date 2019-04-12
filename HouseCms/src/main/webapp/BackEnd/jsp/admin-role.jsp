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
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
         <a href="">管理员管理</a>
        <a href=""><cite>角色管理</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/HouseCms/role/findallRole" method="post" id="myform">
          <input type="text" name="rname"  placeholder="请输入角色名" autocomplete="off" class="layui-input">
          <input type="submit" class="layui-btn"  lay-submit="" lay-filter="sreach" value="搜索">
        </form>
      </div>
      <xblock>
       <shiro:hasPermission name="role:delete">
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
       </shiro:hasPermission>
       <shiro:hasPermission name="role:add"> 
        <button class="layui-btn" onclick="x_admin_show('添加角色','/HouseCms/menu/findMenu')"><i class="layui-icon"></i>添加</button>
       </shiro:hasPermission> 
        <span class="x-right" style="line-height:40px">共有数据：${p.totalnumber} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <input type="checkbox"  name="box" id="selectAll" class="layui-unselect header layui-form-checkbox" lay-skin="primary"/>
            </th>
            <th>ID</th>
            <th>角色名</th>
            <th>拥有权限规则</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="r">
          <tr>
            <td>
              <input type="checkbox" value="${r.rid}"   name="userCheck"  class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'/>
            </td>
            <td>${r.rid}</td>
            <td>${r.rname}</td>
            <td>
            <c:forEach items="${r.listMenu}" var="m" begin="0" end="10">
            ${m.mname}
            </c:forEach>...
            </td>
            <td class="td-status">
              <c:if test="${r.rstatus=='2'}">
            <span class="layui-btn layui-btn-normal layui-btn-mini
              layui-btn-disabled ">已停用
               </span>
              </c:if>
             <c:if test="${r.rstatus=='1'}">
            <span class="layui-btn layui-btn-normal layui-btn-mini">已启用
               </span>
              </c:if>
              </td>
          
            <td class="td-manage">
             <shiro:hasPermission name="role:stastu">
              <a onclick="member_stop(this,'${r.rstatus}','${r.rid}')" href="javascript:;"  title="启用">
               <c:if test="${r.rstatus==2}">
                <i class="layui-icon ">&#xe62f;</i>
                </c:if>
                 <c:if test="${r.rstatus==1}">
                <i class="layui-icon ">&#xe601;</i>
                </c:if>
              </a>
              </shiro:hasPermission>
              <shiro:hasPermission name="role:update">
              <a title="编辑"  onclick="x_admin_show('编辑','/HouseCms/role/findid?rid=${r.rid}')" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>
              </shiro:hasPermission>
              <shiro:hasPermission name="role:stastu">
              <a title="删除" onclick="member_del(this,'${r.rid}')" href="javascript:;">
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
           <a  href="javascript:chaxun('${p.currpage}','${p.rows}');"   class="num" style="background-color:#008B8B;color: white;">${p.currpage}</a>
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
      			data: {"rstatus":2,
      					"rid":id},
      			type: 'POST',
      			url: '/HouseCms/role/updateStastu',
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
        			data: {"rstatus":1,
        					"rid":id},
        			type: 'POST',
        			url: '/HouseCms/role/updateStastu',
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
        			url: '/HouseCms/role/delete',
        			dataType: 'json',
        			success: function(data){
        				$(obj).parents("tr").remove();
        				layer.msg('已删除!',{icon:1,time:1000});
        			},
        			error:function(data) {
        				console.log(data.msg);
        			},
        		});	
          });
      }


      function delAll () {
    	  var checkedNum = $("input[name='userCheck']:checked").length;
  	    if (checkedNum == 0) {
  	        layer.confirm('至少选择一条！');
  	        return;
  	    }
        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
        var rolelist = new Array();
        $("input[name='userCheck']:checked").each(function(){
        	rolelist.push($(this).val());
        });
	    $.ajax({
            type : "post",
            url : "/HouseCms/role/batchDelete",
            data : {rolelist : rolelist.toString()},
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
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();
    </script>
    <script type="text/javascript">
    function chaxun(currpage,rows){
       window.location="/HouseCms/role/findallRole?currpage="+currpage+"&rows="+rows;
    }  
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
    	

    	$("input[name='userCheck']").click(function() {
			var a=0;
			var box=document.getElementsByName("userCheck");
			var b=document.getElementById("selectAll");
			$("input[name='userCheck']").each(function(i,e) {
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