<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- <script src="//cdn.bootcss.com/vue/2.3.3/vue.js"></script> -->

<!-- css 引用 -->
<link rel="stylesheet" type="text/css" href="/static/css/login.css">

</head>
<body class="login">
	<div class="login_m">
		<div class="login_boder">
		    <div class="login_boder_background"></div>
			<div class="login_padding" id="login_model">
				<h2>账号：</h2>
				<label><input type="text" class="txt_input txt_input2" id="accountName" name="accountName" placeholder="邮箱账号或手机"></label>
				<h2>密码：</h2>
				<label><input type="password" class="txt_input" name="password" id="password" placeholder="密码"></label>

				<p class="forgot">
					<a id="iforget" href="javascript:void(0);">忘记密码？</a>
				</p>
				<div class="rem_sub">
					<div class="rem_sub_l">
						<input type="checkbox" name="checkbox" id="save_me"> <label
							for="checkbox">记住我</label>
					</div>
					<label> <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;"></label>
				</div>
			</div>
        </div>
    </div>		
</body>
</html>