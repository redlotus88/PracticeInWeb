<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- TITLE start -->
<div class="container-fluid">
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            全局角色管理 <small>Role Management</small>
        </h1>
    </div>
</div> 
<!-- /. TITLE  -->
<div class="row">
    <div class="col-md-12">
        <!-- Advanced Tables -->
        <div class="panel panel-default">
            <div class="panel-heading">
                 角色列表
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dt_role_list">
                        <thead>
                            <tr>
                                <th class="piw-invisible">ID</th>
                                <th>角色名</th>
                                <th>角色信息描述</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <!--End Advanced Tables -->
    </div>
</div>
 <!-- /. ROW  -->
 
<!-- message -->
<div class="col-md-12" id="message">
	<c:if test="${not empty message}">
		<div class="alert alert-${message.bootstrapType}">
		  ${message.content}
		</div>
	</c:if>
</div>

<div class="col-md-12">
    <button id="btnAdd" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增</button>
    <button id="btnUpdate" type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal" disabled="disabled" >更新</button>
    <button id="btnDelete" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" disabled="disabled">删除</button>
</div>
</div>

<form id="globalRoleForm" name="globalRoleForm" accept-charset="UTF-8" action="/usermgr/globalRole" autocomplete="off" method="post">
	<!-- 添加操作对话框 -->
	<div class="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="addModalLabel">添加新角色</h4>
	            </div>
	            <div class="modal-body container-fluid form-group">
	                <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">新角色:</div>
	                    <div class="col-md-6"><label><input type="text" class="form-control" id="roleCode" name="code" maxlength="20" size="20" placeholder="角色" required autofocus></label></div>
	                </div>
	                <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">描述 :</div>
	                    <div class="col-md-10"><input class="form-control" name="description" id="description" maxlength="100" size="40" placeholder="描述" ></div>
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
</form>

<form id="updateForm" name="updateForm" accept-charset="UTF-8" action="/usermgr/updateGlobalRole" autocomplete="off" method="post">
	<!-- 更新操作对话框 -->
	<div class="modal fade" id="updateModal" tabIndex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="updateModalLabel">更新角色</h4>
	            </div>
	            <div class="modal-body container-fluid form-group">
	                <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">角色:</div>
	                    <div class="col-md-6"><label><input type="text" class="form-control" id="updateCode" name="code" maxlength="20" size="20" placeholder="角色" readonly="readonly"></label></div>
	                </div>
	                 <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">描述 :</div>
	                    <div class="col-md-10"><input class="form-control" id="updateDescription" name="description" maxlength="100" size="40" placeholder="描述" autofocus></div>
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="submit" class="modal-btn-commit btn btn-primary">提交更改</button>
	                
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal -->
	</div>
</form>

<form id="deleteForm" name="deleteForm" accept-charset="UTF-8" action="/usermgr/deleteGlobalRole" autocomplete="off" method="post">
	<!-- 删除操作对话框 -->
	<div class="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="deleteModalLabel">删除账号</h4>
	            </div>
	            <div class="modal-body container-fluid form-group">
	                <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">角色:</div>
	                    <div class="col-md-6"><label><input type="text" class="form-control" id="deleteCode" name="code" maxlength="20" size="20" readonly="readonly"></label></div>
	                </div>
	                 <div class="row modal-attribute">
	                    <div class="col-md-2 modal-attribute-description">描述 :</div>
	                    <div class="col-md-10"><input class="form-control" name="updateDescription" id="deleteDescription" maxlength="100" size="40" readonly="readonly"></div>
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="submit" class="modal-btn-commit btn btn-danger" formaction="/usermgr/deleteGlobalRole" formmethod="post">删除</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal -->
	</div>
</form>