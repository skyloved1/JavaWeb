<%@ page import="main.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看个人信息</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
您的个人信息：
<br>
<p>
    用户名:
    <%=user.getName()%></p >
<p>
    密码：<%=user.getPassword()%></p >
<p>
    邮件:
    <%=user.getEmail()%></p >
<p>
    生日:
    <%=user.getBirthday()%></p >
您的个人信息：
<br>
<p>用户名: ${user.username}</p >
<p>密码：${user.password}</p >
<p>邮件: ${user.email}</p >
<p>生日: ${user.birthday}</p >

</body>
</html>