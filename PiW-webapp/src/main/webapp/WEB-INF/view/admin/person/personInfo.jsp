<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- /.dropdown -->
<li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i></a>
	<ul class="dropdown-menu dropdown-user">
	    <li><a href="#"><i class="fa fa-user-circle fa-fw"></i> 登录为：${accountName} </a></li>
        <li class="divider"></li>
		<li><a href="#"><i class="fa fa-user fa-fw"></i> 个人档案</a></li>
		<li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
		<li class="divider"></li>
		<li><a href="${ctx}/login/logout.do"><i class="fa fa-sign-out fa-fw"></i> 登出</a></li>
	</ul> <!-- /.dropdown-user -->
</li>
<!-- /.dropdown -->