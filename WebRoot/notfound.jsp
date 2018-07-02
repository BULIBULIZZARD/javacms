<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="/static/404/404.css" rel="stylesheet">

<div style="width:100%;text-align:center;" class="un-support-tip">
<img src="/static/404/404.jpg" width="500"/>
<br>
<br>
<br>
<lable style="font-size:20px;"> 您访问的页面不见了</lable>
</div>
