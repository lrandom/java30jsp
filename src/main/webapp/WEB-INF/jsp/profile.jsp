<%@ page import="com.example.javaweb30jsp.models.User" %>
<%@ page import="com.example.javaweb30jsp.Config" %><%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 3/30/23
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <p>Hello <%=((User) request.getAttribute("user")).getEmail()%>
    </p>
    <p>
        <a href="<%=Config.BASE_URL+"logout"%>">Logout</a>
    </p>
</div>
</body>
</html>