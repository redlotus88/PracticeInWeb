<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- title -->
<title>登录: Project 红莲</title>

<!-- meta 信息 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="viewport" content="width=device-width , initial-scale=1.0, minimum-scale=0.5, maximum-scale=1.5,user-scalable=yes">
<meta name="description" content="Project 红莲">
<meta name="author" content="红莲">

<!-- js 引用 -->
<script src="//cdn.bootcss.com/require.js/2.3.3/require.js" data-main="static/js/module/login.js"></script>

<!-- css 引用 -->
<link rel="stylesheet" type="text/css" href="/static/css/login.css">

<script type="text/javascript">
</script>

</head>
<body class="login">
    <!-- 变量定义 -->
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    
    <form class="form-login" action="${ctx}/login.do" method="post">
		<div class="login_m">
		    <div class="login_logo"><img src="static/image/redlotus.jpg" width="150" height="100"></div>
			<div class="login_boder">
			    <div class="login_boder_background"></div>
				<div class="login_padding" id="login_model">
					<h2>账号：</h2>
					<label><input type="text" class="txt_input txt_input2" id="accountName" name="accountName" placeholder="邮箱账号或手机" required autofocus></label>
					<h2>密码：</h2>
					<label><input type="password" class="txt_input" name="password" id="password" placeholder="密码" required></label>
	
					<p class="forgot">
						<a id="iforget" href="javascript:void(0);">忘记密码？</a>
					</p>
					<div class="rem_sub">
						<div class="rem_sub_l">
							<input type="checkbox" name="checkbox" id="save_me"><label for="checkbox">记住我</label>
						</div>
						<label> <input type="submit" class="sub_button" name="button" id="btnLogin" value="登录" style="opacity: 0.7;"></label>
					</div>
				</div>
	        </div>
	    </div>		
    </form>
</body>
</html>