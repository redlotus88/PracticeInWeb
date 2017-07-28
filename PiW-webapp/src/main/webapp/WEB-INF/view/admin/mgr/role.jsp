<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- TITLE start -->
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
    <button id="btnUpdate" type="button" class="btn btn-primary" >更新</button>
    <button id="btnDelete" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" disabled="disabled">删除</button>
</div>
