<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>

<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="header.meta" />
    
    <title>Project 红莲：管理员界面</title>
    <!-- Bootstrap Styles-->
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="//cdn.bootcss.com/morris.js/0.4.3/morris.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link rel="stylesheet" href="<c:url value='/css/admin/custom-styles.css'/>"/>
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- DataTables Bootstrap style -->
    <link href='//cdn.bootcss.com/datatables/1.10.15/css/dataTables.bootstrap.css' rel='stylesheet' type='text/css'/>
        
    <!-- Animsition A simple and easy jQuery plugin for CSS animated page transitions.-->
    <!-- <link href='//cdn.bootcss.com/animsition/4.0.2/css/animsition.min.css' rel='stylesheet' type='text/css' /> -->
    
    <!-- Admin Page Styles -->
    <link rel="stylesheet" href="<c:url value='/css/admin/admin.css'/>" />
    <!-- PiW Styles -->
    <link rel="stylesheet" href="<c:url value='/css/piw-style.css'/>" />
    
</head>

<body>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />

    <div id="wrapper">
        <!-- 顶部导航栏 -->
        <tiles:insertAttribute name="navigation.top" />
        
        <!-- 侧边导航栏 -->
        <tiles:insertAttribute name="navigation.menu"/>
        
        <div id="page-wrapper">
            <div id="page-inner">
                <tiles:insertAttribute name="content"/>
				<tiles:insertAttribute name="footer" />
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <script src="//cdn.bootcss.com/require.js/2.3.3/require.js" data-main="<c:url value='/js/module/admin.js'/>" ></script>
</body>
</html>