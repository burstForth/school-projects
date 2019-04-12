<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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
    <script charset="utf-8" src="<%=basePath%>/BackEnd/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="<%=basePath%>/BackEnd/kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="<%=basePath%>/BackEnd/assets/js/jquery-1.11.2.min.js"></script>
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
    <div class="x-body">
        <form class="layui-form" action="/HouseCms/project/add" method="post" id="myform" enctype="multipart/form-data">
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>项目名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_email" name="pname" required="" lay-verify=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
           <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>项目类别
              </label>
              <div class="layui-input-inline">
                  <select name="ptid">
                  <option value="1">精品住宅</option>
                  <option value="2">商务办公</option>
                  <option value="3">五星酒店</option>
                  <option value="4">高端休闲</option>
                   </select>
              </div>
              
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>项目简介
              </label>
              <div class="layui-input-inline">
                    <textarea id="editor_id1" name="pdescribe" style="width:700px;height:300px;"></textarea> 
              </div>
          </div>
         
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>您要添加的图片
              </label>
              <div class="layui-input-inline">
                  <input  type="file" id="username" name="file" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" >
                 
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
      </form>
    </div>
    <script>
      layui.use(['form','layer'], function(){
          $ = layui.jquery;
        var form = layui.form
        ,layer = layui.layer;
      
        //自定义验证规则
        form.verify({
          nikename: function(value){
            if(value.length < 2){
              return '昵称至少得5个字符啊';
            }
          }
          ,pass: [/(.+){1,12}$/, '密码必须6到12位']
          ,repass: function(value){
              if($('#L_pass').val()!=$('#L_repass').val()){
                  return '两次密码不一致';
              }
          }
        });

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
                x_admin_father_reload();
                $("#myform").submit();
            });
            return false;
          });
        
        
      });
  </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
      
      
      <script>
        KindEditor.ready(function(K) {
            // 实例化编辑器1
            editor1 = K.create('#editor_id1',{
            uploadJson : '"<%=basePath%>"+/HouseCms/BackEnd/kindeditor/jsp/upload_json.jsp',
            fileManagerJson : '"<%=basePath%>"+/HouseCms/BackEnd/kindeditor/jsp/file_manager_json.jsp',
            allowFileManager : true,   //否开启【浏览服务器】功能
            items:['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                    'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                    'anchor', 'link', 'unlink', '|', 'about'
            ],themeType : 'simple',
            afterCreate : function() { 
                this.sync(); 
               }, 
               afterBlur:function(){ 
                   this.sync(); 
               }    
            });
    });
</script>
  </body>

</html>