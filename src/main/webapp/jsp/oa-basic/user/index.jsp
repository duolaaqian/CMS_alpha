<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>用户管理</title>
<!-- script代码 -->
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/oa-basic/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/oa-basic/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/oa-basic/jquery-easyui/datagrid-extra.css">
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
var _page_oa_basic_user = {};
$(function(){
	$("#dg").datagrid({
		url:'${ctx}/oa-basic/easyui/loadDatagrid?key=allUserAdapter',
		columns:[[
			{field:'ID_',checkbox:true},
			{field:'SHOWINDEX_',title:'序号',width:100,align:'center'},
			{field:'USERNAME_',title:'登录名',width:200,align:'center'},
			{field:'REALNAME_',title:'姓名',width:200,align:'center'},
			{field:'STATE_',title:'用户状态',width:100,align:'center',formatter:function(val,row,index){
				switch(val){
					case "1":val="正常";break;
					case "0":val="屏蔽";break;
					default : val="异常";
				}
				return val;
			}},
			{field:'ORG_',title:'所属部门',width:200,align:'center'},
			{field:'opt',title:'操作',width:200,align:'center',formatter:function(val,row,index){
				return "编辑  屏蔽";
			}}
		]],
		height: '100%',
		toolbar: '#tb',
		fit: true,
		rownumbers: true,
		border: false,
		striped: true,
		pageSize: 15,
		pageList: [15,30,60,120,240],
		pagination: true
	});
	
	$('#dd').dialog({
		title: '添加用户',
		width: 400,
		height: 300,
		closed: true,
		modal: true,
		buttons: [{
			text:'保存',
			handler:function(){
				_page_oa_basic_user.addUser();
			}
		}]
	});
	
});

_page_oa_basic_user.addUserPre = function(){
	$("#addUserForm").form('clear');
	$('#dd').dialog('open');
}
_page_oa_basic_user.addUser = function(){
	$.ajax({
		type : "post",
		url:"${ctx}/oa-basic/user/saveUser",
		dataType : "json",
		data : $("#addUserForm").serialize(),
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

</script>
</head>
<body >
	<div id="dg"></div>
	<div id="tb" style="padding:8px;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="javascript:_page_oa_basic_user.addUserPre()">新建用户</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true" >屏蔽用户</a>
	</div>
	
	<div id="dd" style="padding:20px;">
		<form id="addUserForm" >
		<span class="form-item" >
			<span class="form-label" >登录名：</span>
			<span class="form-content" ><input type="text" class="easyui-textbox" name="username" /></span>
		</span>
		<span class="form-item" >
			<span class="form-label" >真实姓名：</span>
			<span class="form-content" ><input type="text" class="easyui-textbox" name="realName" /></span>
		</span>	
		<span class="form-item" >	
			<span class="form-label" >性别：</span>
			<span class="form-content" ><input type="text" class="easyui-textbox" name="" /></span>
		</span>	
		<span class="form-item" >	
			<span class="form-label" >生日：</span>
			<span class="form-content" ><input type="text" class="easyui-textbox" name="" /></span>
		</span>
		<span class="form-item" >	
			<span class="form-label" >序号：</span>
			<span class="form-content" ><input type="text" class="easyui-textbox" name="showIndex" /></span>
		</span>
		</form>
	</div>
</body>
</html>