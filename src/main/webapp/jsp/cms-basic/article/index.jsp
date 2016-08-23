<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>文章管理</title>
<!-- script代码 -->
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/oa-basic/jquery-easyui/datagrid-extra.css">

<script type="text/javascript" src="${ctx}/js/cms-basic/kindeditor/kindeditor-all-min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/cms-basic/kindeditor/themes/default/default.css">

<style type="text/css">
.form-item{
	display: block;
	padding-bottom: 10px;
}
.form-label{
	width: 20%;
	display: inline-block;
	text-align: right;
}
body{
	font-family: verdana,helvetica,arial,sans-serif;
	overflow: hidden;
}
</style>

<script type="text/javascript">
var _page_cms_basic_article = {};
$(function(){
	$("#dg").datagrid({
		url:'${ctx}/oa-basic/easyui/loadDatagrid?key=allArticleAdapter',
		columns:[[
			{field:'ID_',checkbox:true},
			{field:'INDEX_',title:'序号',width:50,align:'center'},
			{field:'TITLE_',title:'标题',width:300,align:'center',formatter:function(val,row,index){
				if(row.TOP_){
					return "<font style='color:red'>[置顶]</font>"+val;
				}
				return val;
			}},
			{field:'CREATE_TIME_',title:'创建时间',width:200,align:'center'},
			{field:'STATUS_',title:'状态',width:100,align:'center',formatter:function(val,row,index){
				switch(val){
					case "1":val="正常";break;
					case "0":val="屏蔽";break;
					default : val="异常";
				}
				return val;
			}},
			{field:'CATALOG_ID_',title:'所属栏目',width:200,align:'center'},
			{field:'opt',title:'操作',width:200,align:'center',formatter:function(val,row,index){
				return "编辑  屏蔽";
			}}
		]],
		height: '100%',
		toolbar: '#tb',
		fit: true,
// 		rownumbers: true,
		border: false,
		striped: true,
		pageSize: 15,
		pageList: [15,30,60,120,240],
		pagination: true
	});
	
	$('#dd').dialog({
		title: '添加文章',
		width: 1100,
		height: 450,
// 		closed: true,
		modal: true,
		buttons: [{
			text:'保存',
			handler:function(){
				_page_cms_basic_article.addArticle();
			}
		}]
	});
	
});

_page_cms_basic_article.addArticlePre = function(){
	$("#addArticleForm").form('clear');
	$('#dd').dialog('open');
}
_page_cms_basic_article.addArticle = function(){
	$('#content').val(editor.html());//同步kindeditor和textarea的值
	$.ajax({
		type : "post",
		url:"${ctx}/cms-basic/article/addArticle",
		dataType : "json",
		data : $("#addArticleForm").serialize(),
		success : function(data) {
			if(data.flag){
				$('#dd').dialog('close');
				$("#dg").datagrid('load');
			}else{
				alert("用户名重复！");
			}

		}
	});
}




var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		allowFileManager : true
	});
});


</script>
</head>
<body >
	<div id="dg"></div>
	<div id="tb" style="padding:8px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="javascript:_page_cms_basic_article.addArticlePre()">新建文章</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true" >屏蔽文章</a>
	</div>
	
	<div id="dd" style="padding:20px;">
		<form id="addArticleForm" >
		<div style="width:300px;float:left;">
			<span class="form-item" >
				<span class="form-label" >标题：</span>
				<span class="form-content" ><input type="text" class="easyui-textbox" name="title" /></span>
			</span>
			<span class="form-item" >
				<span class="form-label" >作者：</span>
				<span class="form-content" ><input type="text" class="easyui-textbox" name="author" /></span>
			</span>	
			<span class="form-item" >	
				<span class="form-label" >创建时间：</span>
				<span class="form-content" ><input type="text" class="easyui-datetimebox" name="createTime" editable=false/></span>
			</span>	
			<span class="form-item" >	
				<span class="form-label" >来源：</span>
				<span class="form-content" ><input type="text" class="easyui-textbox" name="from" /></span>
			</span>
			<span class="form-item" >	
				<span class="form-label" >序号：</span>
				<span class="form-content" ><input type="text" class="easyui-numberbox" name="index" /></span>
			</span>
			<span class="form-item" >	
				<span class="form-label" >所属栏目：</span>
				<span class="form-content" ><input type="text" class="easyui-textbox" name="catalogId" /></span>
			</span>
		</div>
		<div style="float:left;">
			<textarea name="content" id="content" style="width:700px;height:320px;visibility:hidden;"></textarea>
		</div>
		</form>
	</div>
</body>
</html>