<%@ page import="com.example.javaweb30jsp.Config" %><%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 4/25/23
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="container mx-auto">
    <nav class="bg-slate-950 p-4 text-xl text-white flex items-center justify-between">
        <ul class="flex items-center gap-4 ">
            <li><a href="">Home</a></li>
            <li><a href="">Category</a></li>
            <li><a href="">Contact</a></li>
            <li><a href="">Login</a></li>
        </ul>

        <a href="<%=Config.BASE_URL%>cart">Cart</a>
    </nav>

    <div>
        <h4 class="uppercase text-2xl font-bold">Cart</h4>
        <div class="grid grid-cols-5">
            <div class="font-bold">Name</div>
            <div class="font-bold">Price/Pcs</div>
            <div class="font-bold">Quantity</div>
            <div class="font-bold">Total</div>
            <div class="font-bold">Action</div>

            <c:forEach items="${cartItems}" var="cartItem">
                <div>${cartItem.getProduct().getName()}</div>
                <div>${cartItem.getProduct().getPrice()}</div>
                <div>
                    <a class="p-2 bg-black text-white" href="<%=Config.BASE_URL%>change-cart-item-quantity?id=${cartItem.getProduct().getId()}&quantity=-1">-</a>
                        ${cartItem.getQuantity()}
                    <a class="p-2 bg-black text-white" href="<%=Config.BASE_URL%>change-cart-item-quantity?id=${cartItem.getProduct().getId()}&quantity=1">+</a>
                </div>
                <div>${cartItem.getProduct().getPrice()*cartItem.getQuantity()}</div>
                <div>
                    <a href="<%=Config.BASE_URL%>delete-cart-item?id=${cartItem.getProduct().getId()}">Xoá</a>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</body>
</html>
