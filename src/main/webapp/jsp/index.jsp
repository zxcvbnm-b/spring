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
<title>首页</title>
</head>
<body>

<script type="text/javascript">
setTimeout(function() { $("#myElem").hide(); }, 5000);
</script>
<%@include file="pagehead.jsp" %>
 <div class="row" id="center">
  <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12" style=" border-left: 1px aliceblue solid; border-right: 1px aliceblue solid;box-sizing: border-box;padding-bottom: 15px"><h3><span class="glyphicon glyphicon-list" aria-hidden="true"></span> 发现</h3>
  <ul class="nav nav-pills">
  <c:forEach items="${list }" var="cc">
  <li role="presentation"  id="category_check"><a href="/category/${cc.categoryid }">${cc.categoryname}</a></li>
  
  </c:forEach>
</ul><hr>
<!--一个问题  -->
<c:if test="${ questions.list==null}">
<h3>呀 你查找的问题不存啊</h3>
</c:if>
<c:forEach items="${questions.list }" var="question">
			<DIV class="media">
                <DIV class="media-left">
                    <a href="#">
                        <img class="media-object img-rounded" src="img/45600181.jpg" id="img_tao">
                    </a>
                </DIV>
                <DIV class="media-body">
                    <h3 class="media-heading">
                        <a href="/question/${question.questionId }">${question.questionTitle }</a>
                    </h3>
                    <span class="text-desc"><span>${question.reply }</span> 个回复 • <span>${question.browse }</span> 次浏览 • <span ><fmt:formatDate type="date" pattern="yyyy-MM-dd HH" value="${question.createTime}"/>发布</span>
                </DIV>
                <hr>
            </DIV>
            </c:forEach>
            
            <c:if test="${ questions.pages>=2}">
         <div  style="font-size: 18px;margin-top: 30px" id="pageinfo">
            <a  href="?start=1&${search }" class="previous" >首  页</a>
            <a href="/?start=${questions.pageNum-1}&search=${search }" class="previous">上一页</a>
            <a href="/?start=${questions.pageNum+1}&search=${search }" class="previous">下一页 </a>
            <a href="/?start=${questions.pages}&search=${search }" class="previous">末  页</a>
                       一共${questions.pages}页--
                      跳到第<input type="text" id="fenye" size="2">页 <a href="#" id="w3s" class="next" name="${search }">跳到</a>
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
  
  <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
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
                        <a onclick="searchTag(this)" href="#">${ppt}</a>
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
      <input type="checkbox" name="check" value="check">自动登录
    </label>
  </div>
  <button type="submit" class="btn btn-default" id="checklogin">登录</button>
  <button type="button" id="logout" class="btn btn-default">取消</button><br>
  <span >还没有账号？<a href="/register">前去注册！！！</a></span>
   <span ><a href="https://github.com/login/oauth/authorize?client_id=0fb514ce85ccbc822fd1&redirect_uri=http://localhost:8080/callback&scope=user&state=1">使用Github账号登录</a></span>
</form>
</div>

</body>

</html>