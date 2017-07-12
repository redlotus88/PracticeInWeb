<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            个人档案 <small>Public Profile</small>
        </h1>
    </div>
</div>
 
<form action="${ctx}/usermgr/profile/${profileVO.accountId}" method="POST">
	<div class="row">
	   <div class="col-md-12">
			<dl class="form-group">
				<dt>
					<label for="user_profile_name">名字：</label>
				</dt>
				<dd>
					<input class="form-control" id="profileName" name="profileName" size="16" type="text" value="${profileVO.profileName}" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_email">邮件：</label>
				</dt>
				<dd>
				    <input class="form-control" id="publicEmail" name="publicEmail" size="30" type="text" value="${profileVO.publicEmail}" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_company">公司：</label>
				</dt>
				<dd class="user-profile-company-field-container js-suggester-container">
					<input autocomplete="off" class="form-control js-suggester-field" id="company" name="company" size="50" type="text" value="${profileVO.company}" />
				</dd>
			</dl>
			<c:if test="${not empty message}">
				<div class="alert alert-${message.bootstrapType}">
	               ${message.content}
	            </div>
            </c:if>
			<p>
				<button type="submit" class="btn btn-primary">Update profile</button>
			</p>
	   </div>
	</div>
</form>
