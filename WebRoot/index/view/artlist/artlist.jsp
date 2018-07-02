<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../public/static.jsp"%>
<link rel="stylesheet" href="/static/index/style/list.css" type="text/css" />
</head>
<body id="list_style_2" class="list_style_2">
 <script>
 function subForm()
 {
 formsearch.submit();
 //form1为form的id
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
       

    <div id="xh_container">
        <div id="xh_content">

        <div class="path"><a href="${path}">主页</a> > 
        ${search}
        <a href="${path}artlist?id=${parent_id}">${parent_name}</a> 
        <c:if test="${parent_name!=null}">
        > 
        </c:if>
        <a href="${path}artlist?id=${child_id}">${child_name}</a></div><div class="clear"></div>
            <div class="xh_area_h_3" style="margin-top: 40px;">

${noarticle}
<c:forEach var="article" items="${requestScope.articlelist}">     
<div class="xh_post_h_3 ofh">
    <div>
    <h2 class="xh_post_h_3_title ofh">
           <a target="_blank" href="${path}article?id=${article.id}" title="{article.title}">${article.title}</a>
      </h2>
      	<span class="time">${article.create_time}</span>
      	<div class="xh_post_h_3_entry ofh">${article.context}</div>
		<span title="${article.good}人赞" class="xh_love">
		<span class="textcontainer"><span>${article.good}</span></span> 
		<span class="bartext"></span></span> <span title="${article.look}人浏览" class="xh_views">${article.look}</span>
      </div>
    <span class="cat"><a href="${path}artlist?id=${article.category_id}" title="查看 ${article.category_name}中的全部文章"
        rel="category tag">${article.category_name}</a></span>
</div>
</c:forEach>  
            <label> ${pageview}</label>
            </div>
        </div>
        <div id="xh_sidebar" style="backgound:#f4f4f4;">        
<!-- 右侧 -->
         <div class="widget">
<div style="background: url('/static/index/style/img/hots_bg.png') no-repeat scroll 0 0 transparent;width:250px;height:52px;margin-bottom:15px;">
</div>
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
    <div class="boxBor"></div>

    <div class="boxBor" onclick="IBoxBor()" style="cursor:pointer;"></div>
    <script type="text/javascript">
        $(function () {
            var imgHoverSetTimeOut = null;
            $('.xh_265x265 img').hover(function () {
                var oPosition = $(this).offset();
                var oThis = $(this);
                $(".boxBor").css({
                    left: oPosition.left,
                    top: oPosition.top,
                    width: oThis.width(),
                    height: oThis.height()
                });
                $(".boxBor").show();
                var urlText = $(this).parent().attr("href");
                $("#hdBoxbor").val(urlText);
            }, function () {
                imgHoverSetTimeOut = setTimeout(function () { $(".boxBor").hide(); }, 500);
            });
            $(".boxBor").hover(
                function () {
                    clearTimeout(imgHoverSetTimeOut);
                }
                , function () {
                    $(".boxBor").hide();
                }
            );
        });
        function IBoxBor() {
            window.open($("#hdBoxbor").val());
        }
        function goanewurl() {
            window.open($("#hdUrlFocus").val());
        }
</script>

    </div>

<%@include file="../public/footer.jsp"%>
<div style="display: none;" id="scroll">
</div>
<script type="text/javascript" src="/static/index/style/z700bike_global.js"></script>


</body>
</html>

