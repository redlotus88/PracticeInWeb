<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- account.jsp start -->
<!-- 
    form (POST) 提交，Ajax(GET, POST, DELETE) 提交
    Datatables
    bootstrap
    select2
-->

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
<form id="globalAccountForm" accept-charset="UTF-8" action="/usermgr/globalAccount" autocomplete="off" method="post">
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
                                <th>角色</th>
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
    <div class="col-md-12" id="message">
	    <c:if test="${not empty message}">
	        <div class="alert alert-${message.bootstrapType}">
	           ${message.content}
	        </div>
	    </c:if>
    </div>
    <!-- button group -->
    <div class="col-md-12">
        <button id="btnAdd" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增</button>
        <button id="btnUpdate" type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal" disabled="disabled">更新角色</button>
        <button id="btnDelete" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" disabled="disabled">删除</button>
    </div>
    
    <!-- 添加操作对话框 -->
    <div class="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="addModalLabel">添加新账号</h4>
				</div>
				<div class="modal-body container-fluid">
				    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">账号 :</div>
                        <div class="col-md-4"><label><input type="text" class="form-control" id="accountName" name="accountName" maxlength="16" size="16" placeholder="邮箱账号或手机" required autofocus></label></div>
                    </div>
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">密码 :</div>
                        <div class="col-md-4"><input type="password" class="form-control" name="password" id="password" maxlength="16" size="16" placeholder="密码" autocomplete="off" required></label></div>
                    </div>
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">角色 : </div>
                        <div class="col-md-10"><select id="addRole" name="roles" class="modal-role-selection form-control" multiple="multiple"></select></div>
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
	
	<!-- 更新操作对话框 -->
	<div class="modal fade" id="updateModal" tabIndex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="updateModalLabel">更新账号角色</h4>
                </div>
                <div class="modal-body container-fluid">
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">账号 :</div>
                        <div class="col-md-5"><label><input type="text" class="form-control" id="updateAccountName" name="accountName" disabled="disabled"></label></div>
                    </div>
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">角色 : </div>
                        <div class="col-md-10"><select id="updateRole" name="roles" class="modal-role-selection form-control" multiple="multiple"></select></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="btnUpdateModal" type="button" class="modal-btn-commit btn btn-primary" >提交更改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
	
	<!-- 删除操作对话框 -->
	<div class="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="deleteModalLabel">删除账号</h4>
                </div>
                <div class="modal-body container-fluid">
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">ID :</div>
                        <div class="col-md-10"><label><input type="text" class="form-control" id="deleteId" name="id" readonly="readonly"></label></div>
                    </div>
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">账号 :</div>
                        <div class="col-md-10"><label><input type="text" class="form-control" id="deleteAccountName" name="accountName" readonly="readonly"></label></div>
                    </div>
                    <div class="row modal-attribute">
                        <div class="col-md-2 modal-attribute-description">档案名 :</div>
                        <div class="col-md-10"><label><input type="text" class="form-control" id="deleteProfileName" name="accountName" readonly="readonly"></label></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button id="btnDelModal" type="button" class="modal-btn-commit btn btn-danger">删除</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
</div>
 <!-- /. ROW  -->
 </form>
 
 <!-- account.jsp end -->
