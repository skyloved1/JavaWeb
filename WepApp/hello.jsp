<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date, java.text.SimpleDateFormat" %>
<html>
<head>
    <title>My First JSP Page</title>
</head>
<body>
    <%
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
    %>
    <h1>当前时间：<%= time %></h1>
</body>
</html>