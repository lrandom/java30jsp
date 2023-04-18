<%@ page import="com.example.javaweb30jsp.Config" %><%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 4/18/23
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="main"/>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8"/>
</head>
<body>
<c:forEach items="${products}" var="product">
    <div>
        <h4>${product.getName()}</h4>
        <p>${product.getPrice()}</p>
        <a href="">Add To Cart</a>
    </div>
</c:forEach>
</body>
</html>
