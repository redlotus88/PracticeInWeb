<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <h1 class="page-header">
            个人账号 <small>Account</small>
        </h1>
    </div>
</div>
 
<form action="${ctx}/usermgr/account/${profileVO.accountId}" method="POST">
    <div class="row">
       <div class="col-md-12">
            <h3 class="page-header">修改密码</h3>
       
            <dl class="form-group">
                <dt>
                    <label for="user_profile_name">旧密码：</label>
                </dt>
                <dd>
                    <input class="form-control form-control" id="oldPassword" name="oldPassword" size="16" type="password" value="" required="required" placeholder="输入旧密码" />
                </dd>
            </dl>
            <dl class="form-group">
                <dt>
                    <label for="user_profile_email">新密码：</label>
                </dt>
                <dd>
                    <input class="form-control form-control" id="newPassword" name="newPassword" size="16" type="password" value="" required="required" placeholder="输入新密码" />
                </dd>
            </dl>
            <dl class="form-group">
                <dt>
                    <label for="user_profile_company">确认新密码：</label>
                </dt>
                <dd class="user-profile-company-field-container js-suggester-container">
                    <input class="form-control" id="confirmPassword" name="confirmPassword" size="16" type="password" value="" required="required" placeholder="再次输入新密码" />
                </dd>
            </dl>
            <c:if test="${not empty message}">
                <p class="${message.type}">
                   ${message.content}
                </p>
            </c:if>
            <p>
                <button type="submit" class="btn btn-primary">修改密码</button>
                <span><a href="#">忘记密码</a></span>
            </p>
       </div>
    </div>
</form>