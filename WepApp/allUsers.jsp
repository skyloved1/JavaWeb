<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <%ArrayList<User> list=(ArrayList<User>)request.getAttribute("allUsers");%>
所有用户信息：<br>
<table width="300" border="1">
    <tbody>
    <tr>
        <td>&nbsp;用户名</td>
        <td>&nbsp;密码</td>
        <td>&nbsp;邮箱</td>
        <td>&nbsp;生日</td>
    </tr>
    <%
        for(User c:list){
    %>
    <tr>
        <td><%=c.getName() %></td>
        <td><%=c.getPassword() %></td>
        <td><%=c.getEmail() %></td>
        <td><%=c.getBirthday() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<br>
</body>
</html>


