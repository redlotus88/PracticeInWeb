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
                                <th>ID</th>
                                <th>账号</th>
                                <th>档案名</th>
                                <th>角色</th>
                                <th>角色信息</th>
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
