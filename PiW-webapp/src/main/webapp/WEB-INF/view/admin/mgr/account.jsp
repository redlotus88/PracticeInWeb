<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/bootstrap-select/1.12.3/css/bootstrap-select.min.css"/>

<!-- TITLE start -->
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            全局账号管理 <small>Account Management</small>
        </h1>
    </div>
</div> 
<!-- /. TITLE  -->
<form accept-charset="UTF-8" action="/usermgr/globalAccount" autocomplete="off" method="post">
<div class="row">
    <div class="col-md-12">
        <!-- Advanced Tables -->
        <div class="panel panel-default">
            <div class="panel-heading">
                 账号列表
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dt_account_list">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>账号</th>
                                <th>档案名</th>
                                <th>Email</th>
                                <th>公司</th>
                                <th>最后登录时间</th>
                                <th>最后更新时间</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <!--End Advanced Tables -->
    </div>
    <div class="col-md-12">
	    <c:if test="${not empty message}">
	        <div class="alert alert-${message['type']}">${message['message']}</div>
	    </c:if>
    </div>
    <div class="col-md-12">
        <button id="add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增</button>
        <button type="button" class="btn btn-primary">更新</button>
        <button type="button" class="btn btn-danger">删除</button>
    </div>
    
    <div class="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加新账号</h4>
				</div>
				<div class="modal-body">
				    <div>
					    <p>账号 : &nbsp<label><input type="text" class="txt_input txt_input2" id="accountName" name="accountName" maxlength="16" value="${loginVO['accountName']}" placeholder="邮箱账号或手机" required autofocus></label></p>
                    </div>
                    <div>
	                    <p>密码 : &nbsp<label><input type="password" class="txt_input" name="password" id="password" maxlength="16" value="${loginVO['password']}" placeholder="密码" autocomplete="off" required></label></p>
                    </div>
                    <div>
                        <p>角色 : &nbsp <select id="roleType" class="modal-role-selection selectpicker show-tick form-control" multiple data-live-search="false"><option>Mustard</option></select></p>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</div>
 <!-- /. ROW  -->
 </form>
