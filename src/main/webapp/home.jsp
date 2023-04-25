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
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
    <meta charset="utf-8"/>
</head>
<body class="bg-gray-100">

<!--CONTAINER-->
<div class="container mx-auto bg-white p-4">
    <nav class="bg-slate-950 p-4 text-xl text-white flex items-center justify-between">
        <ul class="flex items-center gap-4 ">
            <li><a href="">Home</a></li>
            <li><a href="">Category</a></li>
            <li><a href="">Contact</a></li>
            <li><a href="">Login</a></li>
        </ul>

        <a href="<%=Config.BASE_URL%>cart">Cart</a>
    </nav>

    <h3 class="uppercase text-xl text-black font-bold mt-2">Sản phẩm bán chạy</h3>
    <div class="grid gap-4 grid-cols-4 mt-2">
        <c:forEach items="${products}" var="product">
            <div class="bg-white shadow-log p-2 shadow-gray-300 border rounded-md">
                <img style="height:200px;width:100%;" src="${product.getPath()}" alt="${product.getName()}">
                <h4 class="font-bold">${product.getName()}</h4>
                <p>${product.getPrice()}</p>
                <p>${product.getId()}</p>
                <a href="<%=Config.BASE_URL%>add-to-cart?id=${product.getId()}">Add To Cart</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
