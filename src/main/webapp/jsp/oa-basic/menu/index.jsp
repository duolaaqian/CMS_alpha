<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>菜单管理</title>
<!-- script代码 -->
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/icon.css">
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.easyui.min.js"></script>
<style type="text/css">
</style>

<script type="text/javascript">
$(function(){
	$('#tt').tree({
		 border:false,
	    url:'${ctx}/jsp/oa-basic/menu/tree_data.json'
	});

	$('#dg').datagrid({
// 	    url:'${ctx}/jsp/oa-basic/menu/datagrid_data.json',
	    url:'${ctx}/oa-basic/easyui/loadDatagrid?key=allMenuAdapter',
	    height:'100%',
	    border:false,
	    pagination:true,
	    columns:[[
	        {field:'ID_',title:'Code',width:100},
	        {field:'NAME_',title:'菜单名称',width:100},
	        {field:'CODE_',title:'菜单编码',width:100},
	        {field:'URL_',title:'菜单路径',width:100},
	        {field:'IMGSRC_',title:'图标',width:100},
	        {field:'ISENABLE_',title:'是否可用',width:100},
	        {field:'CREATETIME_',title:'创建时间',width:100}
	    ]]
	});
});

</script>
</head>
<body id="menu_main_frame" class="easyui-layout">
菜单管理页面
	<div data-options="region:'west',split:true" style="width:200px;" id="menu_main_left">
		<div style="padding:3px;border:1px solid #ddd">
			<a href="#" onclick="javascript:addMenu();" data-options="iconCls:'icon-add',plain:true" class="easyui-linkbutton" >添加</a>
			<a href="#" onclick="javascript:addMenu();" data-options="iconCls:'icon-edit',plain:true" class="easyui-linkbutton" >修改</a>
			<a href="#" onclick="javascript:addMenu();" data-options="iconCls:'icon-remove',plain:true" class="easyui-linkbutton" >删除</a>
		</div>
		<ul id="tt"></ul>
	</div>
	<div data-options="region:'center',split:true"id="menu_main_right">
		<div id="dg"></div>
	</div>
	
</body>
</html>