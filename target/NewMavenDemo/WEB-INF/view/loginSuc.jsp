<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.springdemo.entity.User"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>loginSuc</title>
</head>
<body>
	<h1>Login Success!</h1>
	<c:forEach items="${userList}" var="user">
		${user.name}<br/>
	</c:forEach>
	<a href="user/goAddUser.do">ADD</a>
</body>
</html>