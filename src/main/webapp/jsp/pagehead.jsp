<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<nav class="navbar navbar-default">
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
         <input type="text" name="search" value="${search }" placeholder="搜索..">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>  
        <span id="myElem" style="margin: auto;line-height: 50px; padding-left: 150px;color: red;">${error }</span>
       <ul class="nav navbar-nav navbar-right">
        <c:if test="${usera.username!=null }"> 
       <!-- 通知 -->
       <c:if test="${noiceCount!=null}">
         <li ><a class="noiceColor" href="/getnotices/${usera.id }">通知<span class="weiduColor">(${noiceCount}未读)</span></a></li>
         </c:if>
          <c:if test="${noiceCount==null}">
         <li ><a class="noiceColor" href="/getnotices/${usera.id }">通知<span class="weiduColor">(暂时没有未读)</span></a></li>
         </c:if>
    
           </c:if>
       <li  ><a href="/puquestion">提问</a></li>
        <c:if test="${usera.username==null}">
        <li id="denglu" ><a href="#">登录</a></li>
        </c:if>
       
        <c:if test="${usera.username!=null }"> 
        
        <li class="dropdown">
       <c:if test="${usera.imgurl!=null }">
          <a id="showw" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <img src="${usera.imgurl }" style="width: 35px; height:35px">${usera.username } <span class="caret"></span></a>
       </c:if>
        <c:if test="${usera.imgurl==null }">
        <a id="showw" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usera.username } <span class="caret"></span></a>
       </c:if>
         
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
</nav>