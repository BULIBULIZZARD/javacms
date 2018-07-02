<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--包含头部文件-->
<%@include file="../public/header.jsp"%>
<div>${message}<div>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" method="post" action="${path}add">
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">网站名称：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${webname}" readonly="readonly" placeholder="" id="" name="webname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">前台分页数：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${frontpagesize}" readonly="readonly"  placeholder="" id="" name="frontpagesize">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">后台分页数：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${pagesize}" readonly="readonly"  placeholder="" id="" name="pagesize">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">显示分类数：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${navnum}" readonly="readonly"  placeholder="" id="" name="navnum">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">显示广告数：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${advernum}" readonly="readonly"  placeholder="" id="" name="advernum">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-2 col-sm-2">友情链接数：</label>
			<div class="formControls col-xs-5 col-sm-3">
				<input type="text" class="input-text" value="${linknum}" readonly="readonly"  placeholder="" id="" name="linknum">
			</div>
		</div>
	</form>
</article>
<script>
/**定义页面全局变量**/
var SCOPE = {
	"city_url" : "{:url('api/city/getCitysByParentId')}",
	"category_url" : "${path}getchlidcategory",
	"uploadify_swf" : "/static/admin/uploadify/uploadify.swf",
    "image_upload" : "'image.upload'",
};

</script>
<!--包含头部文件-->
<%@include file="../public/footer.jsp"%>
<script type="text/javascript" src="/static/manage/admin/hui/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="/static/manage/admin/hui/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="/static/manage/admin/hui/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="/static/manage/admin/hui/lib/My97DatePicker/WdatePicker.js"></script>

</body>
</html>