<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<%@include file="../public/static.jsp"%>
<script type="text/javascript">
    function IFocuse(th, o) {
        var t = $(th);
        var c = t.attr("class");
        if (o) {
            t.removeClass(c).addClass(c+"-over");
        }
        else {
            t.removeClass(c).addClass(c.replace("-over",""));
        }
    }
</script>
</head>
<body class="xh_body">
<script src="/static/index/style/common.js" type="text/javascript"></script>
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
    <div id="xh_wrapper">
       
<input type="hidden" id="hdUrlFocus" />
    <div class="xh_h_show">
        <div class="xh_h_show_in">
        <div id="zSlider">
            <div id="picshow">
    <div id="picshow_img">
        <ul>
<li style="display: list-item;"><a href="/life/361.html" target="_blank">
                <img src="/static/index/images/1-140206162449A0.jpg" alt="骑行40000公里 英国胶片摄影师的骑游之旅"></a></li>
<li style="display: list-item;"><a href="/life/394.html" target="_blank">
                <img src="/static/index/images/354.jpg" alt="骑看世界：春节骑行海南岛 畅游冬日骑行天堂"></a></li>
<li style="display: list-item;"><a href="/life/364.html" target="_blank">
                <img src="/static/index/images/1-1402061A315209.jpg" alt="隆猫西班牙自行车之旅-Mallorca岛梦幻旅程（上）"></a></li>
<li style="display: list-item;"><a href="/gear/rs/320.html" target="_blank">
                <img src="/static/index/images/1-1402061A155W4.jpg" alt="#CES展上的新玩意# Casio 发布 STB-1000 智能手表 可同步骑行速"></a></li>
        </ul>
    </div>
</div>
<div id="select_btn">
    <ul>
        <li class="current"></li><li class=""></li><li class=""></li><li class=""></li>
    </ul>
</div>
            <div class="focus-bg-title"><div id="focus-left" class="arrow-left" onmouseover="IFocuse(this,true)" onmouseout="IFocuse(this,false)"></div>
            <div id="focus-center" class="focus-title">
            <div style="float:left;width:580px;padding-left:10px;font-size:18px;" id="focus-tl-s"></div>
            <div style="float:right;width:200px;"></div>
            </div>
            <div id="focus-right" class="arrow-right"></div></div>
            </div>
            <div id="picshow_right">
      <a href="/life/416.html" target="_blank">
    <img src="/static/index/images/1-140206160415Y6.jpg" alt="COACH再度携手王力宏 踩单车演" width="255px" height="420px"></a>
   
            <div id="picshow_right_cover" onclick="goanewurl()" style="cursor:pointer;position:absolute;top:495px;font-size:14px;width:213px;height:45px;line-height:45px;padding-left:42px;color:#ffffff;zoom:1;background-image:url(/static/index/images/focus-left-bg.png); background-repeat:no-repeat; background-color:#01A1ED;"></div>
            </div>
        </div>
    </div>
    <div id="xh_container">
    <a name="new"></a>
        <div id="xh_content" style="padding-right:10px;">
            <div class="xh_area_h_3">
             
                
<c:forEach var="article" items="${requestScope.articlelist}">               
<div class="xh_post_h_3 ofh">
    <div>
    <h2 class="xh_post_h_3_title ofh">
           <a target="_blank" href="${path}article?id=${article.id}" title="${article.title}">${article.title}</a>
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
</div>
        </div>
        <div id="xh_sidebar">
		<div>
		<c:if test="${login==0}">
			<form method="post" action="${path}login">
				用户名:<br/>
				<input type="text" name="username" value=""/><br/>
				密码　:<br/>
				<input type="password" name="password" value=""/><br/>
				<span style="padding-top:20px;"><input style="background: #fff;border:none;cursor: pointer;" type="submit" name="login" value="登陆"/></span>
				<span>还没有账号?<a style="color:green;cursor:pointer;text-decoration:underline;" href="${path}register">立即注册</a></span>
				<br/>
			</form>
		</c:if>
		<c:if test="${login==1}">
		<div style="font-size:16px">
			欢迎 ${username}<br/>
			<a href="${path}logout" style="color:green">退出登陆</a><br/>
		</div>
		</c:if>
		</div>
         <div class="widget">

<div style="background: url('/static/index/style/img/hots_bg.png') no-repeat scroll 0 0 transparent;width:250px;height:52px;margin-bottom:15px;">
</div>
<label>广告</label>
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
    </div>
</div>
            <div class="widget links">
                <h3>
                    友情链接</h3>
                <ul>
                <c:forEach var="link" items="${requestScope.linklist}">   
                <li><a href='${link.link}' target='_blank'>${link.name}</a> </li>
                </c:forEach>
                </ul>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="boxBor" onclick="IBoxBor()" style="cursor:pointer;"></div>
    <input type="hidden" id="hdBoxbor" />
    <script type="text/javascript">

        $("#next-page").hover(function () { $(this).attr("src", "/static/index/style/images/next02.png"); }, function () { $(this).attr("src", "/static/index/style/images/next01.png"); });
        $("#last-page").hover(function () { $(this).attr("src", "/static/index/style/images/last02.png"); }, function () { $(this).attr("src", "/static/index/style/images/last01.png"); });

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
