<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="main.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<% User user=(User)request.getAttribute("user"); %>
您的个人信息：<br>
用户名：<%=user.getName() %><br>
密码：<%=user.getPassword() %><br>
邮箱：<%=user.getEmail() %><br>
生日：<%=user.getBirthday() %><br>
</body>
</html>