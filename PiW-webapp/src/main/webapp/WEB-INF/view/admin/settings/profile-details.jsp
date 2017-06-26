<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            个人档案 <small>Public Profile</small>
        </h1>
    </div>
</div>
 
<form action="${ctx}/usermgr/${accountName}">
	<div class="row">
	   <div class="col-md-12">
			<dl class="form-group">
				<dt>
					<label for="user_profile_name">Name</label>
				</dt>
				<dd>
					<input class="form-control" id="user_profile_name" name="user[profile_name]" size="30" type="text" value="Vermilion" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_email">Public email</label>
				</dt>
				<dd>
				    <input class="form-control" id="user_profile_email" name="user[profile_email]" size="50" type="text" value="illidan70@163.com" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_company">Company</label>
				</dt>
				<dd class="user-profile-company-field-container js-suggester-container">
					<input autocomplete="off" class="form-control js-suggester-field" id="user_profile_company" name="user[profile_company]" size="30" type="text" value="Shanghai Newtouch co.ltd" />
				</dd>
			</dl>
			<dl class="form-group">
				<dt>
					<label for="user_profile_location">Location</label>
				</dt>
				<dd>
					<input class="form-control" id="user_profile_location" name="user[profile_location]" size="30" type="text" value="" />
				</dd>
			</dl>
			<p>
				<button type="submit" class="btn btn-primary">Update profile</button>
			</p>
	   </div>
	</div>
</form>
