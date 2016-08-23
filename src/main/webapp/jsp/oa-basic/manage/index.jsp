<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>哆啦a芊网站后台管理系统</title>
<link href="${ctx}/images/logo.png" rel="shortcut icon" />
<!-- script代码 -->
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${ctx}/css/oa-basic/manage/index.css">
	
<style type="text/css">
</style>

<script type="text/javascript">
// console.info('${param.a}');
// alert('${user.realName}');
refreshPanel = function(){
	var tab = $('#tt').tabs('getSelected');  // 获取选择的面板
	var iframe = $(tab).find('iframe');
	var src = iframe.attr('src');
	
	if(src.indexOf("?")>-1){
		src += "&_time="+Math.random();
	}else{
		src += "?_time="+Math.random();
	}
	
	iframe.attr('src',src);
// 	tab.panel('refresh');

}
addTab = function(title,url){
	var flag = $('#tt').tabs('exists',title);
	if(flag){
		$('#tt').tabs('select',title);
	}else{
		$('#tt').tabs('add',{
			title:title,
			selected:true,
			closable:true,
// 			href:url
			content:'<iframe src="'+url+'" style="width:100%;height:100%;border:0"></frame>'
		});
	}

}
</script>
</head>
<body class="easyui-layout">
	<!--<div class="easyui-layout" style="width:700px;height:350px;">-->
<%-- 		<div class="index_banner" data-options="region:'north'" style="height:80px;background:url(${ctx}/banner1.png) repeat-x;"> --%>
		<div data-options="region:'north',split:true" class="index_banner">
		<div style="position: absolute;left: 130px;top: 6px;color:#F0F8FF;font:normal bold 22px/50px arial,sans-serif;">
			CMS 网站后台管理系统
		</div>
		<div style="line-height:66px;float:right;padding-right:40px;color:#ffffff;font-size:14px;" >
		欢迎 ${user.realName} ! 
		修改密码
		<a href="${ctx}/j_oa_security_logout">退出</a>
		</div>
		
		<!--<img src="banner/banner1.png" style="width:100%" />-->
		</div>
		<div data-options="region:'south',split:true" style="height:34px;background-color:#E0ECFF;">
			<div class="panel-title" style="text-align:center;line-height:24px;">
				by 哆啦A芊   Email:1255771777@qq.com
			</div>
		</div>
		<div data-options="region:'west',split:true,collapsible:false,headerCls:'t-center'" title="菜单" style="width:150px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="网站管理" style="padding:10px;" data-options="collapsible:true" >
					站点管理
					栏目管理
					文章管理
					<a id="btn" href="#" style="width:100%;" onclick="javascript:addTab('文章管理','${ctx}/cms-basic/article');" class="easyui-linkbutton" data-options="iconCls:'icon-large-clipart',plain:true,size:'large',iconAlign:'left',toggle:true">文章管理</a>
				</div>
				<div title="网站维护" style="padding:10px;">
					<a id="btn" href="#" style="width:100%;" class="easyui-linkbutton" data-options="iconCls:'icon-large-clipart',plain:true,size:'large',iconAlign:'left',toggle:true">框架管理</a>
					<a id="btn" href="#" style="width:100%;" class="easyui-linkbutton" data-options="iconCls:'icon-large-picture',plain:true,size:'large',iconAlign:'left',toggle:true">模板管理</a>
					<a id="btn" href="#" style="width:100%;" class="easyui-linkbutton" data-options="iconCls:'icon-large-smartart',plain:true,size:'large',iconAlign:'left',toggle:true">样式管理</a>
					<a id="btn" href="#" style="width:100%;" onclick="javascript:addTab('demo','${ctx}/demo');" class="easyui-linkbutton" data-options="iconCls:'icon-larg-demo',plain:true,size:'large',iconAlign:'left',toggle:true">demo</a>
				</div>
				<div title="系统管理" data-options="selected:true" style="padding:10px">
					<a id="btn" href="#" style="width:100%;" onclick="javascript:addTab('用户管理','${ctx}/oa-basic/user');" class="easyui-linkbutton" data-options="iconCls:'icon-user',plain:true,size:'large',iconAlign:'left',toggle:true">用户管理</a>
					<a id="btn" href="#" style="width:100%;" class="easyui-linkbutton" data-options="iconCls:'icon-group',plain:true,size:'large',iconAlign:'left',toggle:true">角色管理</a>
					<a id="btn" href="#" style="width:100%;" onclick="javascript:addTab('菜单管理','${ctx}/menu');" class="easyui-linkbutton" data-options="iconCls:'icon-larg-menu',plain:true,size:'large',iconAlign:'left',toggle:true">菜单管理</a>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'报表管理 / SQL设计',tools:[{iconCls:'icon-reload',handler:refreshPanel}]">
			<div id="tt" class="easyui-tabs" data-options="tabPosition:'bottom',fit:true,border:false,plain:false">
				<div title="About" data-options="href:'content.html',closable:true" style="padding:10px"></div>
				<div title="DataGrid" style="padding:5px" data-options="closable:true">
					<table class="easyui-datagrid"
							data-options="url:'../jsp/oa-basic/manage/datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div>
				<div title="tree+grid" data-options="href:'tree.html',closable:true" style="padding:10px"></div>	
			</div>
		</div>
	<!--</div>-->
</body>
</html>