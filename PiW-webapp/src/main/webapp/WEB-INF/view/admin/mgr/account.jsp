<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- TITLE start -->
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            全局账号管理 <small>account management</small>
        </h1>
    </div>
</div> 
<!-- /. TITLE  -->

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
</div>
 <!-- /. ROW  -->
