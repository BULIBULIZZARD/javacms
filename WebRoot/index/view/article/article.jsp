<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="/static/index//style/style.css" />       
<%@include file="../public/static.jsp"%>
<link rel="stylesheet" href="/static/index/style/article.css" type="text/css" />
<script language="javascript" type="text/javascript" src="/include/dedeajax2.js"></script>

<script type="text/javascript">

function ILike(th, v) {
    if (v) {
        $(th).addClass("single_views_over");
    }
    else {
        $(th).removeClass("single_views_over");
    }
}

</script>
 
</head>
<body class="single2">
   <script>
 function subForm()
 {

 formsearch.submit();
 //form1ä¸ºformçid
 }
 </script>
<script type="text/javascript">
    function showMask() {
        $("#mask").css("height", $(document).height());
        $("#mask").css("width", $(document).width());
        $("#mask").show();
    }  
</script>
<div id="mask" class="mask" onclick="CloseMask()"></div> 
<%@include file="../public/header.jsp"%>
    <div id="wrapper">

    <div id="wrapper">
        <div id="container">
            <div id="content">
                <div class="post" id="post-19563" style="border-right: solid 1px #000000; min-height: 1700px;
                    margin-top: 10px;">
                    <div class="path"><a href="${path}">主页</a> > 
				        ${search}
				        <a href="${path}artlist?id=${parent_id}">${parent_name}</a> 
				        <c:if test="${parent_name!=null}">
				        > 
				        </c:if>
				        <a href="${path}artlist?id=${child_id}">${child_name}</a></div><div class="clear"></div>
                    <div class="single_entry single2_entry">
                        <div class="entry fewcomment">
                            <div class="title_container">
                                <h2 class="title single_title">
                                    <span>${title}</span><span class="title_date"></span></h2>
                                <p class="single_info">时间：${time}&nbsp;&nbsp;&nbsp;作者：${author}</p>
                            </div>
                            <br>
                            <br>
                            <div class="div-content">
                                <p>
                                	${text}
                                </p>
                                </div>
                            </div>
                            <div class="clear">
                            </div>
                            <div id="ctl00_ctl00_ContentPlaceHolder1_contentPlace_divRead">
                                <div style="text-align: left; width: 100%; font-size:18px;padding-bottom:20px;border-bottom: solid 1px #e0e0e0; padding-bottom: 4px;
                                    color: Black; vertical-align: middle; font-weight: bold;">
                                    &nbsp;&nbsp;评论列表
                                </div>
                                <br/>
                                <br/>
                                ${nocomment}
                                <c:if test="${nocomment!=null }">
                                <br/>
                                <br/>
                                </c:if>
                                <c:forEach var="comment" items="${requestScope.commentlist}">
                                <div class="xh_post_h_3 ofh" style="padding-left: 20px;">
								    <div>
								    <h2 class="xh_post_h_3_title ofh" >
								           	${comment.username }
								      </h2>
								      	<span class="time">${comment.create_time }</span>
								      	<div class="xh_post_h_3_entry ofh" style="font-size:16px;color:#333">${comment.context }</div>
								      </div>
								</div>
								</c:forEach>
                                <p style="color:#333;font-size:20px;">添加评论</p>
                                <form method="post" action="${path}comment">
                                <input type="hidden" value="${a_id}" name="article_id"/>
                                <div style="width:100%;text-align: center;">
                                <textarea style="width:600px;height:200px;resize: none;font-size:18px;" name="context"></textarea>
                                </div>
                                <p style="padding-left:45%;padding-top:20px;"><input type="submit" style="font-size:18px;cursor: pointer"></p>
                                </form>
                            </div>
                            <div class="clear">
                            </div>
                            <div class="comments_wrap" style="margin-top: 35px;">
                                <a name="comment"></a>
          <!-- Duoshuo Comment BEGIN -->
          <div class="ds-thread" data-thread-key="" 
    data-title="" data-author-key="" data-url=""></div>
          <script type="text/javascript">
   
    </script> 
          <!-- Duoshuo Comment END --> 
                            </div>
                            <div class="clear">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="sidebar">
                <div class="widget single" style="margin-bottom: 0px; margin-left: 0px; margin-top: 40px;
                    padding-bottom: 0px;" id="newdigg">
                    <div class="single_views" onmouseout="ILike(this,false)" onmouseover="ILike(this,true)">
                        <span class="textcontainer"><span class="votecount26536">${thegood}</span></span> <span class="bartext voteid26536">
                        <a id="aZanImg" class="good"  ></a></span><span class="text" id="spanZan">赞</span>
                        <span class="text love">人</span>
                    </div>
                </div>
<!-- 右侧 -->

         <div class="widget">
<br/>
<br/>
<br/>
广告
<ul id="ulHot">
<li style="border-bottom:dashed 1px #ccc;height:20px; margin-bottom:15px;">
</li>
<c:forEach var="adver" items="${requestScope.adverlist}">   
<li style="border-bottom:dashed 1px #ccc;height:70px; margin-bottom:15px;">
<div style="float:right;width:100%;height:52px; overflow:hidden;">
<a href="${adver.url}" target="_blank" title="${adver.title}">${adver.title}</a></div>
</li>
</c:forEach>
</ul>
                </div>
            
            <div class="widget portrait">
    <div>
        <div class="textwidget">
                 

        </div>
    </div>
</div>
                
                
            </div>
            <div class="clear">
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/static/index//style/z700bike_global.js"></script>
    <script type="text/javascript" src="/static/index//style/z700bike_single.js"></script>
  
    <script type='text/javascript' src='/blog4/static/index//style/jquery.colorbox-min.js?ver=1.3.17.2'></script>
    </div>
<script type="text/javascript"> 

$(".good").click(function(){
//抛送逻辑
	var id = ${a_id};
	var postData = {
		'goodid' : id,
	};
	var url="${path}good";
	//抛送http
	$.post(url,postData,function(result){
		alert(result.message);
	},"json");
}); 
 
</script> 
    
<%@include file="../public/footer.jsp"%>
<div style="display: none;" id="scroll">
</div>
<script type="text/javascript" src="/static/index/style/z700bike_global.js"></script>

 
</body>
</html>
