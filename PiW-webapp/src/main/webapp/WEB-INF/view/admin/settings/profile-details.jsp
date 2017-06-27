<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            个人档案 <small>Public Profile</small>
        </h1>
    </div>
</div>
 
<form action="${ctx}/usermgr/${profileVO.accountName}">
	<div class="row">
	   <div class="col-md-12">
			<dl class="form-group">
				<dt>
					<label for="user_profile_name">Name</label>
				</dt>
				<dd>
					<input class="form-control" id="profileName" name="profileName" size="16" type="text" value="${profileVO.profileName}" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_email">Public email</label>
				</dt>
				<dd>
				    <input class="form-control" id="publicEmail" name="publicEmail" size="30" type="text" value="${profileVO.publicEmail}" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_company">Company</label>
				</dt>
				<dd class="user-profile-company-field-container js-suggester-container">
					<input autocomplete="off" class="form-control js-suggester-field" id="company" name="company" size="50" type="text" value="${profileVO.company}" />
				</dd>
			</dl>
			<p>
				<button type="submit" class="btn btn-primary">Update profile</button>
			</p>
	   </div>
	</div>
</form>
