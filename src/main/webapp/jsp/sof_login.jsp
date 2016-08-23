<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>登陆</title>
<!-- script代码 -->
<style type="text/css">
.logins{
	border: 1px solid blueviolet;
	padding: 30px;
	width: 30%;
	margin: 0 auto;
}
.user label,.password label{
	display : inline-block;
	width : 100px;
	text-align: right;
}
.logins input{
	width:200px;
}
.login_btn{
/* 	float: right; */
	text-align: right;
}
.user,.password,.save_password,.login_btn{
	padding-bottom: 20px;
}
.foot_copy{
	text-align: right;
	font-size: 85%;
	color: gray;
}


</style>

<script type="text/javascript">
// $(function(){

// });

function login(){
// 	alert(1);
	document.logins.submit();
}


</script>
</head>
<body>
<h3><center>登陆</center></h3>
<form class="logins" id="logins" name="logins" action="${ctx}/j_oa_security_check" method="post">
	<div class="user">
		<label>用户名：</label>
		<input value="sysadmin" name='j_username' id='j_username' type="text" class="username" onKeyPress="javascript:if(event.keyCode==13){login();}" tabindex="1" />
	</div>
	<div class="password">
		<label>密&nbsp;&nbsp;码：</label>
		<input value="111111" type='password' name='j_password' id='j_password' class="password_txt" size="20" tabindex="2" onKeyPress="javascript:if(event.keyCode==13){login();}"/>
	</div>
	<!-- 
	<div class="save_password">
		<input name="" type="checkbox" value="" checked />
		<label>记住用户名</label>
	</div>
	 -->
	<!-- 
	<div class="red_font">
		<span id="loginTip">请输入用户名和密码进行操作</span>
		<span id="loginError" style="display:none">用户名或密码错误，请重新登录！</span>
		<span id="ipError" style="display:none">您的当前IP无权限登陆！  </span>
		<span id="kong" style="display:none">用户名不能为空，请输入！</span>
	</div>
	 -->
	<div class="login_btn">
		<a href="javascript:void(0);" onclick="login();return false;" tabindex="3" class="login_ing"><span>登陆</span></a>
	</div>
	<div class="foot_copy">
		<p>网站后台管理系统</p>
		<p>联系方式：1255771777@qq.com</p>
	</div>	  
</form>
</body>
</html>