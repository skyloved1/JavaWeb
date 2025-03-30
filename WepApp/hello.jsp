<%@ taglib uri="/myTabLib" prefix="mm" %>
<html>
<head>
    <title>My First JSP Page</title>
</head>
<body>
    <mm:hello/>:<%= request.getAttribute("USER") %>
</body>
</html>
