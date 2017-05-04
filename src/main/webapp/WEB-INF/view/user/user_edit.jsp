<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>Edit User</title>
</head>
<body>
	<form id="userForm" action="updateConfirm.do" method="post">
		id:<input type="text" name="id" id="user_id"/>
		username:<input type="text" name="username" id="username" />
		password:<input type="password" name="password" />
		name:<input type="text" name="name" />
		<a onclick="confirm();"><input type="button" value="Confirm" /></a>
		<!-- <input type="submit" value="Confirm" /> -->
	</form>
	<script type="text/javascript" src="../static/jquery-1.7.2.js"></script>
</body>

<script type="text/javascript">
	function confirm() {
		//alert("Inside the func!");
		/* if ($("#user_id").val() == "") {
			alert("ID is null");
		} else {
			alert("ID is not null");
		} */
		
		
		hasUser();
	}
	
	function hasUser() {
		//alert("The 2nd func!");
		var username = $.trim($("#username").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasU.do',
			data: {username:username},
			dataType: 'json',
			success: function(data) {
				if (data == null)
					alert("data is null!")
				alert(data);
				if ("success" == data.result) {
					alert("success!");
					$("#userForm").submit();
				} else {
					alert("Username already exists, opr's failed!");
				}
			}
		});
	}
</script>

</html>