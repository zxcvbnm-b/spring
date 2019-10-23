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
<title>个人主页</title>
</head>
<body>

</body>
<%@include file="pagehead.jsp" %>
<!-- <nav class="navbar navbar-default">
  <div class="container-fluid">
    Brand and toggle get grouped for better mobile display
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">校园网xxx</a>
    </div>
  
    Collect the nav links, forms, and other content for toggling
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-left">
        <div class="form-group">
        <input type="text" name="search" placeholder="搜索..">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>  
    </div>/.navbar-collapse
  </div>/.container-fluid
</nav> -->
<div id="register_div">
<form action="/personal_data/update" method="post" >
  <div class="form-group">
    <label for="exampleInputEmail1">用户名</label>: <label for="exampleInputEmail1">${user_info.username}</label>
  </div>
  <div class="form-group" >
   <label for="exampleInputEmail1">性别</label>: <label for="exampleInputEmail1">
   <!--  比较写在里面-->
   <c:if test="${user_info.sex ==1}">男</c:if>
   <c:if test="${user_info.sex ==2}">女</c:if>
 
   </label>
    </div class="form-group">
  <div class="form-group">
    <label for="exampleInputFile">个人头像:</label>
    <img class="media-object img-rounded" src="/img/45600181.jpg" id="img_tao">
  </div>
 <label for="exampleInputEmail1">简介:</label>
  <span>${user_info.introduction }<span>
    <div class="form-group">
    <label for="exampleInputEmail1">发布的问题数目：</label>: <label for="exampleInputEmail1">${count}</label>
  </div>
</form>
</div>
</html>