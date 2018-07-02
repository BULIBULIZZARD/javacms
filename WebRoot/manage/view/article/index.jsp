<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--包含头部文件-->
<%@include file="../public/header.jsp"%>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 文章管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="" type="checkbox" value=""></th>
					<th width="80">ID</th>
					<th width="100">分类</th>
					<th width="100">标题</th>
					<th width="150">新增时间</th>
					<th width="60">状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${requestScope.article}">
				<tr class="text-c">
					<td><input name="" type="checkbox" value=""></td>
					<td>${article.id}</td>
					<td>${article.category_name}</td>
					<td><a href="../../index/article?id=${article.id}"  target="_blank">${article.title}</a></td>
					<td>${article.create_time}</td>
					<td class="td-status"><span class='label label-success radius'>正常</span></td>
					<td class="td-manage"><a style="text-decoration:none" class="ml-5" 
					onClick="o2o_s_edit('修改文章','${path}edit?id=${article.id}')" href="javascript:;" title="编辑">
					<i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" 
					onClick="o2o_del('${path}del?id=${article.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				</c:forEach>
			</tbody>    
		</table>
	</div>
</div>
<div>${pageview}</div>


<!--包含头部文件-->
<%@include file="../public/footer.jsp"%>
<script>
	var SCOPE={
		'listorder_url':"category.listorder",
	};
</script>
</body>
</html>