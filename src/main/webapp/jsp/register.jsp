<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/login.js"></script>
<link href="/css/login.css" rel="stylesheet">
<title>注册</title>
</head>
<body>
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
  <div id="login_div" class="panel">
 <!--  -->
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
  <button type="submit" class="btn btn-default">登录</button><br>
  <button type="submit" id="logout" class="btn btn-default">取消</button><br>
  <span >还没有账号？<a href="">前去注册！！！</a></span>
</form>
</div>
<!--注册  -->
<div id="register_div">
<form action="/register_success" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">用户名</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="username" name="username" value="${username }">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="passwd" name="passwd">
  </div>
  <div>
    <input type="radio" name="sex" id="optionsRadios1" value="1" <c:if test="${sex}==1">checked</c:if>>男
    
    <input type="radio" name="sex" id="optionsRadios2" value="2" <c:if test="${sex}==2">checked</c:if>>女
    </div>
  <div class="form-group">
    <label for="exampleInputFile">头像上传</label>
    <input type="file" id="exampleInputFile" name="img_file">
    <p class="help-block">请选择你的头像.</p>
  </div>
  简介
 <textarea class="form-control" rows="3" name="introduction" value="${ introduction}"></textarea>
 
    <div>
  <button type="submit" class="btn btn-default">注册</button>
  <button type="reset" class="btn btn-default">重制</button>
   <a href="/"><button type="button" class="btn btn-default" id="quxiao">取消</button></a> 
  </div>
</form>
</div>
</body>

</html>