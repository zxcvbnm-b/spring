<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>我的消息</title>
</head>
<body>
<%@include file="pagehead.jsp" %>
<%-- <nav class="navbar navbar-default">
  <div class="container-fluid" >
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
        <c:if test="${usera.username!=null }"> 
       <!-- 通知 -->
         <li ><a class="noiceColor" href="/getnotices/${usera.id }">通知</a></li>
           </c:if>
       <li  ><a href="/puquestion">提问</a></li>
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
 <div class="row" id="center">

  <div class="col-xs-12 col-md-8" style=" border-left: 1px aliceblue solid; border-right: 1px aliceblue solid;box-sizing: border-box;padding-bottom: 15px"><h3><span class="glyphicon glyphicon-list" aria-hidden="true"></span><span>发现</span></h3>
     <h3>关于我的回复</h3>
     <c:forEach items="${noticelist }" var="notice">
		  <h4>
		  <!-- 如果类型为1表示是回复了问题，如果是2表示回复的是评论 -->	  	 
		 <c:if test="${notice.notification.noticeType==1 }">
		  <!-- 如果状态为0表示未读 -->
		
		 <a href="/personal_data/${ notice.usersss.id}">${notice.usersss.username }</a> 评论了问题<a href="/question/${notice.question.questionId }?checklook=${notice.notification.notificationId}">${notice.question.questionTitle }</a>
		  <c:if test="${notice.notification.noticeState==0 }">
		  <span class="label label-danger">未读</span>
		  <span style="position: absolute;right: 20px;"><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${notice.notification.createTime}"/></span>
		 </c:if>
		 <c:if test="${notice.notification.noticeState==1 }">
		 <span class="label label-default">已读</span>
		 <span style="position: absolute;right: 20px;"><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${notice.notification.createTime}"/></span>
		 </c:if>
		 </c:if>
		 	
		 </h4>
		  <h4> 
		  <c:if test="${notice.notification.noticeType==2 }">
		  <!-- 如果状态为0表示未读 -->
		 
		<a href="/personal_data/${ notice.usersss.id}">${notice.usersss.username }</a>回复了评论<a href="/question/${notice.question.questionId }?checklook=${notice.notification.notificationId}">${notice.question.questionTitle }</a>
		   <c:if test="${ notice.notification.noticeState==0}"><span class="label label-danger">未读</span>
		   <span style="position: absolute;right: 20px;"><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${notice.notification.createTime}"/></span>
		 </c:if>
		  <c:if test="${notice.notification.noticeState==1 }">
		  <span class="label label-default">已读</span>
		   <span style="position: absolute;right: 20px;"><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${notice.notification.createTime}"/></span>
		 </c:if>
		 </c:if>
		
		 </h4>
		  </c:forEach>
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>	
</html>