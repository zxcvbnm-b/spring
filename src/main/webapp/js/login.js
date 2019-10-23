

function clicked() {
	  var title1=$("#titlel").val();
	  var testarea=$("#testarea").val();
	  var title=$("#title").val();
	  if(!title){
		  alert("标题不能为空！！！");
		  return false;
	  }else if(!testarea){
		  alert("内容不能为空！！！");
		  return false;
	  }
	  else if(!title1){
		  alert("标签不能为空！！！");
		  return false;
	  }else{
		  
		  return true;
	  }
    }

$(document).ready(function(){
	//提问时判断是否为空
	$("#denglu").click(function(){
		  $("#login_div").toggle();
		});
	$("#checklogin").click(function(){
		  $("#login_div").hide();
		  
		});
	$("#showw").click(function(){
		  $("#show").toggle();
		});
	$("#logout").click(function(){
		  $("#login_div").hide();
		});
	$("#quxiao").click(function(){
		  $("#register_div").hide();
		});
	$("#category_check").click(function(){
		 $("#category_check").addClass("active");
		});
	
	$("#w3s").click(function(){
		var pageNum= $("#fenye").val();
		$("#w3s").attr("href","/?start="+pageNum);
		});
	  
	$("#w3ss").click(function(){
		var tt=$("#user_id").val();
		 var searc=$("#w3s").attr("name");
		var pageNum= $("#fenyes").val();
		$("#w3ss").attr("href","/question/user_question/"+tt+"?start="+pageNum+"&search="+searc);
		});	
	
	//一级评论
	$("#comment_button").click(function(){
		var id=	$("#question_id").val();
		var  content=	$("#comment_content").val();
		var  user_id=	$("#useraid").val();
		if(!content){
			alert("不能回复空内容！！");
			return;
		}
		$.ajax({
			   type: "POST",
			   url: "/comment",
			   data: JSON.stringify({
				   parent_id:id,
				   content:content,
				   code:1,
				   usera_id:user_id
			   }),
			   contentType:"application/json"
			   ,
			   success: function(msg){
			    if(msg.code=='2006'){
			    	var r=confirm(msg.message);
			    	if (r==true){
			    		 $("#login_div").show();
			    	}
			    	
			    }
			    if(msg.code=='2007'){
			    	alert(msg.message);
			    }
//			    提交成功后，关闭回复框
			     if(msg.code==2005){
			    	alert(msg.message);
			    	/*$("#tijiao").hide();*/
			    	 window.location.reload();
			    }
			   }
			});		
		});	

//二级评论
	
});
function laiya(obj){
	
	var aa= $(obj).text();
	var bb= $("#titlel").val();
	if(bb.indexOf(aa)!=-1){
		
		
	}else{
	
	if(bb){
		 $("#titlel").val(bb+","+aa);
		
	}else{
		 $("#titlel").val(aa);
		
	}
	}
	
}

function   posta(one){
	$.ajax({
		   type: "POST",
		   url: "/labels/"+one,
		   contentType:"application/json"
		   ,
		   success: function(msg){
		    
//		    提交成功后，关闭回复框
		     if(msg.code==2005){
		    	  $("#info").html("");//清空info内容
		    	 $.each(msg.object, function(index,item){ 
		    		 $("#info").append(
		    				 "<a id='one' onclick='laiya(this)'>" + item + "</a>");
		    	    });  
		    }
		    
		   }
	
		});		
}
function getQuestion(es){
	var idd=$(es).attr("id");
	var id=	$("#commenttid").val();	
	$.ajax({
		   type: "POST",
		   url: "/comment/"+idd,
		   data: JSON.stringify({
			   parent_id:idd,
			  
			   code:2,
		
		   }),
		   contentType:"application/json"
		   ,
		   success: function(msg){
		    
//		    提交成功后，关闭回复框
		     if(msg.code==2005){
		    	  $("#info"+idd).html("");//清空info内容
		    	 $.each(msg.object, function(index,item){ 
		    		 $("#info"+idd).append(
		    				 "<div>" + item.user.username + "</div>" + 
		    				 "<div>" + item.content + "</div><hr/>");
		    	    });  
		    	 
		    }
		    
		   }
	
		});		
  $("#comment-"+idd).fadeToggle();
  
}
//二级评论
function commentsss(es){
	
	var idd=$(es).attr("id");
		var  content=	$("#input-"+idd).val();
		var  user_id=	$("#useraid").val();
		if(!content){
			alert("不能回复空内容！！");
			return;
		}
		$.ajax({
			   type: "POST",
			   url: "/comment",
			   data: JSON.stringify({
				   parent_id:idd,
				   content:content,
				   code:2,
				   usera_id:user_id
			   }),
			   contentType:"application/json"
			   ,
			   success: function(msg){
			    if(msg.code==2006){
			    
			    }
			    if(msg.code==2007){
			    	alert(msg.message);
			    }
//			    提交成功后，关闭回复框
			     if(msg.code==2005){
			    	alert(msg.message);
			    	/*$("#comment-908").hide();*/
			    	 window.location.reload();
			    
			    }
			   }
			});		
	
	
}


function searchTag(abj){
	var tag=abj.innerHTML;
	alert(tag);
	window.location.href="/?search="+tag;
}


