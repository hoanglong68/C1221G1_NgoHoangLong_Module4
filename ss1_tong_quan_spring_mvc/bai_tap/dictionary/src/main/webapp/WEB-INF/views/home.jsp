<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/29/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/translate" method="get">
    <h1>DICTIONARY</h1>
    <input type="text" name="word" placeholder="enter word">
    <input type="submit">
</form>
<%--<c:import url="result-search.jsp"></c:import>--%>
</body>
</html>
