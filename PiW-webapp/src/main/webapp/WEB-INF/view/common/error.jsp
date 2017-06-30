<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红莲系统异常</title>
</head>
<!--   
    错误详细信息页面。 
 -->
<body>
    <h1>系统发生异常：</h1>
    <p>程序发生异常，请将以下此错误发送到<a href="mailto:jialong.wang@newtouch.cn?subject=错误报告&body=${errorMessage}">jialong.wang@newtouch.cn</a></p>
    <p>${errorMessage}<p>
</body>
</html>