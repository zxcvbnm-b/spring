<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/login.css" rel="stylesheet">
<script src="/js/login.js"></script>
   <link rel="stylesheet" href="/css/editormd.css" />
 
				<script src="/js/editormd.min.js"></script>
<title>发布问题</title>
</head>
<body>

<script type="text/javascript">
setTimeout(function() { $("#myElem").hide(); }, 5000);

</script>
<%@include file="pagehead.jsp" %>
<%-- <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">校园网xxx</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-left">
        <div class="form-group">
        <input type="text" name="search" placeholder="搜索..">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>  
        <span id="myElem" style="margin: auto;line-height: 50px; padding-left: 150px;color: red;">${error }</span>
       <ul class="nav navbar-nav navbar-right">
          <!-- 通知 -->
         <li><a href="/getnotices/${usera.id }">通知</a></li>
        <c:if test="${usera.username==null}">
        <li id="denglu" ><a href="#">登录</a></li>
        </c:if>
        <c:if test="${usera.username!=null }"> 
        <li class="dropdown">
          <a id="showw" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usera.username } <span class="caret"></span></a>
          <ul class="dropdown-menu" id="show"><!--class="dropdown-menu"  -->
            <li><a href="/personal_data/${usera.id }">个人资料</a></li>
            <li><a href="/question/user_question/${usera.id}">我的问题</a></li>
            <li><a href="/logout?userid=${usera.id }">退出登录</a></li>
          </ul>
        </li>
       </c:if> 
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> --%>
 <!--  发起问题-->
 <div class="container main">
    <div class="row" id="center-puQuestion">
        <!--左边部分-->
        <div class="col-lg-9 col-md-12 col-sm-12 container-fluid" style=" border-left: 1px aliceblue solid; border-right: 1px aliceblue solid;box-sizing: border-box;padding-bottom: 15px">
            
            <h2><span class="glyphicon glyphicon-plus"></span><span class="fui-list-thumbnailed"></span>&nbsp;&nbsp;<strong>标题</strong></h2>
            <hr>
            <form style="border-top: 1px solid #eee;" id="publish_form" action="/addquestion" method="post">
            <input type="hidden" name="userId" value="${usera.id }">
                <div class="row">
                    <!--标题-->
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <input type="text"  class="form-control" id="title" name="questionTitle" placeholder="标题">
                    </div>
                </div>
                <!--描述信息-->
                   <h4><label for="bs-example-navbar-collapse-1">问题补充 (必填,请参照右侧提示)</label></h4>
                  <div class="row">
          
			
				
				<script type="text/javascript">
			
				    $(function() {
				        var editor = editormd("test-editor", {
				             width  : "97%",
				             height : "350",
				            path   : "/js/lib/",
				            delay:0,
				            watch:false,
				            imageUpload    : true,
				            imageFormats   : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
				            imageUploadURL : "/file/upload",
				        });
				    });
				</script>
                 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="test-editor">
                    <textarea rows="6" class="form-control col-lg-12 col-md-12 col-sm-12 col-xs-12" name="label" style="display:none;" id="testarea"></textarea>
                </div>
                
                
                
                   </div>
                   <h4> <label for="bs-example-navbar-collapse-1">问题标签</label></h4>
                <div class="row">
                    <!--标题-->
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <input type="text" value="" class="form-control" id="titlel" name="describes" placeholder="标签">
                    </div>
                  </div>
                <!--提示信息-->
                <div class="form-group">
                    <input style="float: right; margin-bottom: 100px;" type="submit" value="发布" class="btn btn-primary btn-default" id="publishBtn" 	onclick="return clicked();">
                </div>
          
            </form>
           
           <ul id="myTab" class="nav nav-tabs">
           <c:forEach items="${labels_category}" var="one">
          
          <li >
        <a href="/labels/${one.id }" data-toggle="tab" onclick="posta(${one.id})">
      		 ${one.categoryName }
      	</a>
   		</li>
    </c:forEach>
</ul>
 <p id="info" style="margin-bottom: 20px;padding-bottom: 30px;"></p>
           
           
        </div>
        <!--右边部分-->
        <br>
        <div class="col-lg-3 col-md-12 col-sm-12 rightwrapper">
            <strong style="margin-top: 20px;color: #303030;"><span class="iconfont icon-wenti"></span>&nbsp;问题发起指南</strong>
            <hr>
            <small>
                • <strong>问题标题:</strong> 请用准确的语言描述您发布的问题思想。请用精简的语言描述您发布的问题，不超过25字
            </small>
            <br>
            <br>
            <small>
                • <strong>问题补充:</strong>  详细补充您的问题内容, 并提供一些相关的素材以供参与者更多的了解您所要问题的主题思想。
            </small>
            <br>
            <small>
                • <strong>选择标签:</strong>  选择一个或者多个合适的标签，用逗号隔开，每个标签不超过10个字
            </small>
            <br>
            <br>
            <small>
                • <strong>选择话题:</strong>  选择一个或者多个合适的话题, 让您发布的问题得到更多有相同兴趣的人参与. 所有人可以在您发布问题之后添加和编辑该问题所属的话题.
            </small>
        </div>
        <p></p>

    </div>
</div>
 
 
 <!--  登錄-->
  <div id="login_div" class="panel">
 <%--  <span>${error}</span> --%>
<form action="/login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">用户名</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name="passwd">
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox" name="check" value="check">自动登录
    </label>
  </div>
  <button type="submit" class="btn btn-default" id="checklogin">登录</button>
  <button type="button" id="logout" class="btn btn-default">取消</button><br>
  <span >还没有账号？<a href="/register">前去注册！！！</a></span>
</form>
</div>

</body>

</html>