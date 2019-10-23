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
<title>出错了！！！</title>
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
<div class="jumbotron" style="min-height: 300px;">
    <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12"><h3>出错啦！！！</h3>
        <p>${errora }</p>
        <p><a class="btn btn-primary btn-lg" href="/" role="button">回到主页</a></p>
    </div>
    <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
        <img class="img-thumbnail" style="width: 35%;" src="/images/official.jpg">
    </div>
</div>
</body>

</html>