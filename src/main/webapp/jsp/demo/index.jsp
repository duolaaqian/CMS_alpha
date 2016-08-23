<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>demo</title>
<!-- script代码 -->
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/icon.css">
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
</style>

<script type="text/javascript">
$(function(){
	$('#tt').tree({
		border:false,
// 		checkbox:true,
		lines:true,
	    url:'${ctx}/jsp/oa-basic/menu/tree_data.json'
	});

	$('#dg').datagrid({
	    url:'${ctx}/jsp/oa-basic/menu/datagrid_data.json',
	    border:false,
	    columns:[[
			{field:'a',checkbox:true},
	        {field:'code',title:'Code',width:100},
	        {field:'name',title:'Name',width:100},
	        {field:'price',title:'Price',width:100,align:'right'}
	    ]],
	    rownumbers:true,
	    striped:true,
	    pagination:true,
	    height:'100%',
	    toolbar:[{
	    	text:'添加',
	    	iconCls:'icon-add'
	    },{
	    	text:'修改',
	    	iconCls:'icon-edit'
	    },{
	    	text:'删除',
	    	iconCls:'icon-remove'
	    },'-']
	});
});

</script>
</head>
<body id="menu_main_frame" class="easyui-layout">
demo
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