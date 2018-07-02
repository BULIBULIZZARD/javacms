<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--包含头部文件-->
<%@include file="../public/header.jsp"%>
<body>
<div class="page-container">
	<form class="form form-horizontal form-o2o-add" id="form-o2o-add" method="post" action="${path}edit">
	<input type="hidden" name="id" value="${edit_id}">
		<div class="row cl">
			<label>${msg}</label>
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${name}" placeholder="" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类栏目：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="parent_id" class="select">
					<option value="0">一级分类</option>
					<c:forEach var="cate" items="${requestScope.catelist}">
					<c:if test="${cate.id==parent_id}">
					<option value="${cate.id}" selected="selected"> -${cate.name}</option>
					</c:if>
					<c:if test="${cate.id!=parent_id}">
					<option value="${cate.id}"> -${cate.name}</option>
					</c:if>
					</c:forEach>
				</select>
				</span>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button  type="submit" class="btn btn-primary radius" ><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
</div>
<!--包含头部文件-->
<%@include file="../public/footer.jsp"%>
