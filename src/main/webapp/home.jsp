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
<%--<p>
    <c:out value="Hello"/>
<ul>--%>
<%--  <c:forEach items="${list}" var="item">
      <li>
          <c:out value="${item}"/>
      </li>
  </c:forEach>


  <c:if test="${age >= 18}">
      <c:out value="Bạn đã đủ tuổi kết hôn"/>
  </c:if>

  <c:choose>
      <c:when test="${age >= 18}">
          <c:out value="Bạn đã đủ tuổi kết hôn"/>
      </c:when>
      <c:when test="${age >= 16}">
          <c:out value="Bạn chưa đủ tuổi kết hôn"/>
      </c:when>
      <c:otherwise>
          <c:out value="Bạn chưa đủ tuổi kết hôn"/>
      </c:otherwise>
  </c:choose>

  <c:set var="listAge" value="12,13,14,15"/>
  <c:forTokens items="${listAge}" var="item" delims=",">
      <c:out value="${item}"/>
  </c:forTokens>

  <fmt:formatNumber value="${1000000}" type="currency" currencySymbol="VND"/>
--%>
<button>
    <fmt:message key="Submit"/>
</button>

<p>
    <fmt:message key="Welcome"/>
</p>

<form method="post" action="<%=Config.BASE_URL+"ServletHome"%>">
    <select name="language">
        <option value="en">English</option>
        <option value="vi_VN">VietNamese</option>
        <option value="ja_JP">Japanese</option>
    </select>
    <button>Change Language</button>
</form>

</ul>
</p>
</body>
</html>
