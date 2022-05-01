<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/29/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:if test="${result != null}">
    <h1 style="color: red ">Translated: ${result}</h1>
</c:if>
<%--<c:if test="${result == null}">--%>
<%--    <h1>Translated: Not Found !</h1>--%>
<%--</c:if>--%>
<button><a href="/home">come back home !</a></button>
</body>
</html>
