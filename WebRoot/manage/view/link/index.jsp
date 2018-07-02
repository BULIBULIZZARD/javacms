<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--包含头部文件-->
<%@include file="../public/header.jsp"%>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 链接管理 <span class="c-gray en">&gt;</span> 链接列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" onclick="o2o_s_edit('添加链接','${path}add','','300')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加链接</a></span> <span class="r"></span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="" type="checkbox" value=""></th>
					<th width="80">ID</th>
					<th width="80">排序</th>
					<th width="100">连接名称</th>
					<th width="150">链接</th>
					<th width="150">新增时间</th>
					<th width="60">状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="link" items="${requestScope.linklist}">
				<tr class="text-c">
					<td><input name="" type="checkbox" value=""></td>
					<td>${link.id}</td>
					<td class="text-c listorder"><input type="text" size="3" style="text-align: center;" attr-id="${link.id}" name="listorder" value="${link.listorder}"></td>
					<td>${link.name}</td>
					<td><a href="${link.link}" target="_blank">${link.link}</a></td>
					<td>${link.create_time}</td>
					<td class="td-status"><span class='label label-success radius'>正常</span></td>
					<td class="td-manage"><a style="text-decoration:none" class="ml-5" 
					onClick="o2o_s_edit('修改链接','${path}edit?id=${link.id}','',300)" href="javascript:;" title="编辑">
					<i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" 
					onClick="o2o_del('${path}del?id=${link.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
		'url' : "${req}",
		'listorder_url':"${path}listorder",
	};
</script>
</body>
</html>