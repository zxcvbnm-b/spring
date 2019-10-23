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
	<link rel="stylesheet" href="/css/editormd.preview.css" />
	<script src="/js/editormd.js"></script>
	<script src="/js/lib/marked.min.js"></script>
	<script src="/js/lib/prettify.min.js"></script>

<link href="/css/login.css" rel="stylesheet">
<script src="/js/login.js"></script>
<title>问题详情</title>
</head>
<body>
<%@include file="pagehead.jsp" %>
<div class="container-fluid main profile">
    <div class="row" id="center">

        <!--左边主要内容-->
        <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12" style=" border-left: 1px aliceblue solid;box-sizing: border-box;padding-bottom: 15px"> 
            <!--正文-->
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                <h4 class="question-title"><span>${question_info.questionTitle }</span></h4>
                <span class="text-desc" style="color: rgb(153, 153, 153);,font-size: 12px">
                作者：<span >${question_info.user.username }</span> |
                发布时间：<span ><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${question_info.createTime}"/></span>
                阅读数： <span>${question_info.browse }</span>
            </span>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 top-header">
                    <a href="https://gio.ren/w/noqdMJPk" target="_blank" style="color: #A00;font-weight: bold;">阿里、腾讯、美团、网易 Java 面试全集</a>
                    <img src="/images/hot.png">
                </div>

                <!--内容-->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 markdown-body editormd-html-preview" id="question-view">
                	<textarea style="display:none;">${question_info.label }</textarea>      
				</div>
				<script type="text/javascript">
				    $(function() {
					 editormd.markdownToHTML("question-view", {
				        });
				    });
				</script>  
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="width: 100%; margin: 0px; padding: 0px; border-width: 0px;">
                    <script async="" src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
                    <!-- 页尾广告 -->
                    <ins class="adsbygoogle" style="display: block; height: 280px;" data-ad-client="ca-pub-9804684553882114" data-ad-slot="4772323686" data-ad-format="auto" data-full-width-responsive="true" data-adsbygoogle-status="done" data-overlap-observer-io="false"><ins id="aswift_0_expand" style="display:inline-table;border:none;height:280px;margin:0;padding:0;position:relative;visibility:visible;width:1004px;background-color:transparent;"><ins id="aswift_0_anchor" style="display:block;border:none;height:280px;margin:0;padding:0;position:relative;visibility:visible;width:1004px;background-color:transparent;"><iframe marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no" allowfullscreen="true" onload="var i=this.id,s=window.google_iframe_oncopy,H=s&amp;&amp;s.handlers,h=H&amp;&amp;H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&amp;&amp;d&amp;&amp;(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}" id="aswift_0" name="aswift_0" style="left: 0px; position: absolute; top: 0px; border: 0px none; width: 1004px; height: 280px; overflow: visible;" width="1004" height="280" frameborder="0"></iframe></ins></ins></ins>
                    <script>
                        (adsbygoogle = window.adsbygoogle || []).push({});
                    </script>
                </div>

                <!--标签-->
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <c:forEach items="${splits} " var="tss" >
                    <span class="label label-info" style="font-size: 15px;margin-right: 5px;">
                        <a href="/?page=1&amp;tag=java" class="community-tag">${tss}</a>
                    </span>
                    </c:forEach>
                </div>

                <!--编辑-->
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    
                </div>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            </div>

            <!--回复-->
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h4>
                    <span>${question_info.reply }</span> 个回复
                </h4>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comment-sp">
                
            </div>
              <!-- 显示回复 -->
              <c:forEach items="${list_Comment }" var="commentt">
               <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comments">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                               <img class="media-object img-rounded" src="/img/45600181.jpg" id="img_tao">
                            </a>
                        </div>
                        <div class="media-body" id="comment-body-${commentt.id  }">
                            <h5 class="media-heading">
                                <span>${commentt.user.username }</span>
                            </h5>
                            <div>${commentt.content }</div>
                            <div >
                                <span class="glyphicon glyphicon-thumbs-up icon menu"></span>
                                <span  class="comment-icon">
                              
                                    <span class="glyphicon glyphicon-comment menu " onclick="getQuestion(this)" id="${commentt.id }"></span>
                                      <span>${ commentt.likeCount}</span>
                                 
                                  
                                </span>
                                <span class="pull-right"><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm" value="${commentt.commentTime}"/>发布
                            </div>
                             
                            <!--二级评论-->
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 "  style="display: none;" id="comment-${commentt.id }">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <p id="info${commentt.id }" ></p>
                                    <input type="text" class="form-control" placeholder="评论一下……" id="input-${commentt.id }">
                                    <button type="button" class="btn btn-success pull-right" onclick="commentsss(this)" id="${commentt.id }" >评论
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              </c:forEach>
              
            <!--回复输入框-->
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="tijiao">
                <h4>
                    提交回复
                </h4>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comment-sp">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="comment_section">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object img-rounded" src="/images/default-avatar.png">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <span>匿名用户</span>
                            </h5>
                        </div>
                    </div>       
                    <!--  得到当前登录的id-->            
                    <input type="hidden" id="useraid" value="${usera.id}">
                    <!--  得到当前评论的id-->
                    <input type="hidden" id="question_id" value="${question_info.questionId }">
                    <textarea class="form-control comment" rows="6" id="comment_content"></textarea>
                    <button type="button" class="btn btn-success btn-comment " id="comment_button" >回复</button>
                </div>
               
            </div>
            

        </div>

        <!--右边信息块-->
        <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h4>发起人</h4>
                <div class="media">
                    <div class="media-left">
                        <a href="#">
                         <img class="media-object img-rounded" src="/img/45600181.jpg" id="img_tao">
                        </a>
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading">
                            <span>${question_info.user.username }</span>
                        </h5>
                    </div>
                </div>
            </div>
            <div><div>
    <!--码问官方公众号-->
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 side">
        <h4>官方微信</h4>
        <img class="img-thumbnail question-wechat" src="/images/official-account.png">
    </div>
</div></div>
            <div><div>
    <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 side">
        <a href="http://www.mawen.co/question/261" onclick="clickSide(&quot;UCloud&quot;)" target="_blank">
            <img class="img-thumbnail question-wechat" src="http://mawen-cdn.cn-bj.ufileos.com/uhost.png">
        </a>
    </div>
    
</div>
</div>

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
</div>
<!--  登錄-->
  <div id="login_div" class="panel">
 <%--  <span>${error}</span> --%>
<form action="/login" method="post" target=“_blank”>
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