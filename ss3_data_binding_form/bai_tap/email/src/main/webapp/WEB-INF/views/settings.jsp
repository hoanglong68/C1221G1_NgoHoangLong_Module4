<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<h2 style="color: red">${message}</h2>
<form:form action="/update" method="post" modelAttribute="email">
    <div>language:
        <form:select path="language">
            <option value="English">English</option>
            <option value="Vietnamese">Vietnamese</option>
            <option value="Japanese">Japanese</option>
            <option value="Chinese">Chinese</option>
        </form:select>
    </div>
    <div>Page Size: show
        <form:select path="pageSize">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </form:select>
    </div>
    <div>
        Spams filter:
        <form:checkbox path="spamFilter"/> enable spams filter
    </div>
    <div>
        <form:textarea path="signature"/>
    </div>
    <div>
        <input type="submit" value="update">
    </div>
    <div>
        <input type="button" value="cancel">
    </div>
</form:form>
<button><a href="/list">Show List Email</a></button>
</body>
</html>
