<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--包含头部文件-->
<%@include file="../public/header.jsp"%>
<div>${message}<div>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" method="post" action="${path}edit">
	<input type="hidden" name="id" value="${id}" >	
	基本信息：
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>链接名称：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" class="input-text" value="${name}" placeholder="" id="" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>链接地址：</label>
			<div class="formControls col-xs-8 col-sm-3">
				<input type="text" class="input-text" value="${linkurl}" placeholder="" id="" name="link">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>	
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