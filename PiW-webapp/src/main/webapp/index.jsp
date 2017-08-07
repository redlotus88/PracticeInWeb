<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<script type="text/javascript">
    <%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
    window.location.href="<%= basePath%>/login";
</script>
<body>
<h2>Hello World!</h2>
</body>
</html>
