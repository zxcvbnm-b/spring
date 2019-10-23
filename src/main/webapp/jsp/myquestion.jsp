<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.min.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/login.js"></script>
<link href="/css/login.css" rel="stylesheet">
<title>我的问题</title>
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
         <li  ><a href="/puquestion">提问</a></li>
        <c:if test="${usera.username==null}">
        <li id="test" ><a href="#">登录</a></li>
        </c:if>
        <c:if test="${usera.username!=null }">
        <li class="dropdown">
          <a id="showw" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usera.username } <span class="caret"></span></a>
          <ul class="dropdown-menu" id="show">
            <li><a href="#">个人资料</a></li>
            <li><a href="/question/${usera.id }">我的问题</a></li>
            <li><a href="/logout?userid=${usera.id }">退出登录</a></li>
          </ul>
        </li>
        </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
 
  </div>
</nav>  --%>
<div class="row" id="center">
  <div class="col-xs-12 col-md-8" style=" border-left: 1px aliceblue solid; border-right: 1px aliceblue solid;box-sizing: border-box;padding-bottom: 15px"><h3 style="margin-bottom: 60px;"><span class="glyphicon glyphicon-list" aria-hidden="true">我发布的问题</span></h3>
  <hr>
 <c:forEach items="${questions.list }" var="question">
<DIV class="media">
                <DIV class="media-left">
                    <a href="#">
                        <img class="media-object img-rounded" src="/img/45600181.jpg" id="img_tao">
                    </a>
                </DIV>
                <DIV class="media-body">
                    <h3 class="media-heading">
                        <a href="/question/${question.questionId }">${question.questionTitle }</a>
                    </h3>
                    <span class="text-desc"><span>${question.reply }</span> 个回复 • <span>${question.browse }</span> 次浏览 • <span ><fmt:formatDate type="date" pattern="yyyy-MM-dd HH" value="${question.createTime}"/>发布</span>
                </DIV>
            </DIV>
            <hr>
            </c:forEach>
            <c:if test="${ questions.pages>=2}">
              <div  style="font-size: 18px;margin-top: 30px" id="pageinfo">
            <a  href="?start=1" class="previous">首  页</a>
            <a href="/?start=${questions.pageNum-1}" class="previous">上一页</a>
            <a href="/?start=${questions.pageNum+1}" class="previous">下一页 </a>
            <a href="/?start=${questions.pages}" class="previous">末  页</a>
                       一共${questions.pages}页--
                      跳到第<input type="text" id="fenye" size="2">页 <a href="#" id="w3s" class="next">跳到</a>
                      <!-- 获取各个键盘按键的id -->
         <!--  <script type="text/javascript">
          var input = document.getElementById("fenye");
          input.addEventListener("keyup", function(event) {
              event.preventDefault();
              if (event.keyCode === 13) {
                  document.getElementById("w3s").click();
              }
          });
           
           </script>  -->
           <script type="text/javascript">
           $(window).keyup(function(event){
        	   if(event.keyCode==13) {
        		   document.getElementById("w3s").click();/* 执行点击事件 */
        	   }
        	 });
           
           </script>
                     
    </div>  
  </c:if>
  </div>
  
  <div class="col-xs-6 col-md-4">
     <!--右边信息块-->
                    <!--相关问题-->
            <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h4>热门问题</h4>
               
                <ul class="question-related" style="list-style-type: none;cursor: pointer;">
                 <c:forEach items="${xiangguanwenti}" var="pp" varStatus="a">
                    <li>
                      <span>${a.count}.</span>   <a href="/question/${pp.questionId }">${pp.questionTitle }</a>
                    </li>
                      </c:forEach>
                </ul>
              
            </div>
             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h4>热门标签</h4>
               
                <ul class="question-related" style="list-style-type: none;cursor: pointer;">
                 <c:forEach items="${remenwenti}" var="ppt">
                    <li style="display: inline-block;background-color: lightskyblue;border: 2px aliceblue solid;border-radius: 5px;padding: 2px;">
                        <a href="#">${ppt}</a>
                    </li>
                      </c:forEach>
                </ul>
              
            </div>
  
  
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
      <input type="checkbox" name="check">自动登录
    </label>
  </div>
  <button type="submit" class="btn btn-default" id="checklogin">登录</button>
  <button type="button" id="logout" class="btn btn-default">取消</button><br>
  <span >还没有账号？<a href="/register">前去注册！！！</a></span>
</form>
</div>

</body>

</html>