<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="//cdn.bootcss.com/select2/4.0.3/css/select2.min.css" rel="stylesheet">

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
    <!-- message -->
    <div class="col-md-12">
	    <c:if test="${not empty message}">
	        <div class="alert alert-${message.bootstrapType}">
	           ${message.content}
	        </div>
	    </c:if>
    </div>
    <div class="col-md-12">
        <button id="btnAdd" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增</button>
<!--         <button type="button" class="btn btn-primary">更新</button> -->
        <button id="btnDelete" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" disabled="disabled">删除</button>
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
					    <p>账号 : &nbsp<label><input type="text" class="txt_input txt_input2" id="accountName" name="accountName" maxlength="16" value="${accountVO['accountName']}" placeholder="邮箱账号或手机" required autofocus></label></p>
                    </div>
                    <div>
	                    <p>密码 : &nbsp<label><input type="password" class="txt_input" name="password" id="password" maxlength="16" value="${accountVO['password']}" placeholder="密码" autocomplete="off" required></label></p>
                    </div>
                    <div>
                        <p>角色 : &nbsp<select name="roles" class="modal-role-selection form-control" multiple="multiple"></select></p>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="modal-btn-commit btn btn-primary" >提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<div class="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"s aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">删除账号</h4>
                </div>
                <div class="modal-body">
                    <div>
                        <p>账号 : &nbsp<input type="text" class="txt_input txt_input2" id="accountName" name="accountName" maxlength="16" disabled="disabled" autofocus></p>
                    </div>
                    <div>
                        <p>密码 : &nbsp<input type="password" class="txt_input" name="password" id="password" maxlength="16" disabled="disabled"></p>
                    </div>
                    <div>
                        <p>角色 : &nbsp<input type="text" class="txt_input txt_input2" id="roles" name="roles" disabled="disabled"></p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="modal-btn-commit btn btn-primary" >提交更改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
</div>
 <!-- /. ROW  -->
 </form>
