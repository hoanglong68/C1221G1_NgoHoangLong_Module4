<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/29/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/" method="post">
    <input type="number" name="usd" placeholder="enter usd" value="0">
    <input type="submit">
</form>
<hr>
<c:if test="${result != null}">
    Result: <fmt:formatNumber>${result}</fmt:formatNumber> VND
</c:if>
</body>
</html>
