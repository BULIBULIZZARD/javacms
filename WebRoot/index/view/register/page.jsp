<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../public/static.jsp"%>
    <style type="text/css">
        #wrapper
        {
            background-color: #ffffff;
        }
        .single_entry{margin-top:30px;}
    </style>
</head>
<body class="single2">

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
        <div class="single_entry page_entry">
            <div class="entry">
                <h2 style="margin: 0px 0px 20px; padding: 0px; border: 0px; font-size: 22px; vertical-align: baseline; font-family: 'Microsoft Yahei', 'Trebuchet MS', Arial, Tahoma, Helvetica, sans-serif; line-height: 26px; color: rgb(51, 51, 51);">
    注册成为本站用户</h2>
    <div style="width:100%;margin:auto;">
    <table border="0" style="width:80%;background:#f4f4f4;margin:auto;font-size:20px;border-collapse:separate; border-spacing:20px 20px;">
    <form method= "post" action="${path}register">
    <tr><td style="text-align:center;">用户名:</td><td><input style="height:20px;" type="text" name="username"><span style="color:#f00">*</span><span style="font-size:12px;">(2~20)</span></td></tr>
    <tr><td style="text-align:center;">密码:</td><td><input style="height:20px;"  type="password" name="password"><span style="color:#f00">*</span><span style="font-size:12px;">(6~20)</span></td></tr>
    <tr><td style="text-align:center;">确认密码:</td><td><input style="height:20px;"  type="password" name="repassword"><span style="color:#f00">*</span></td></tr>
    <tr><td style="text-align:center;">邮箱地址:</td><td><input style="height:20px;"  type="text" name="email"><span style="color:#f00">*</span></td></tr>
    <tr><td style="text-align:center;">QQ号:</td><td><input style="height:20px;"  type="text" name="qq"></td></tr>
    <tr><td style="text-align:right;"  ><input  style="height:40px;width:50px;font-size:20px;"  type="submit" value="注册"></td></tr>
    </form>
    </table>
    </div>

                <div class="clear">
                </div>
            </div>
    </div>

    </div>
<%@include file="../public/footer.jsp"%>
<div style="display: none;" id="scroll">
</div>
<script type="text/javascript" src="/static/index/style/z700bike_global.js"></script>
</body>
</html>