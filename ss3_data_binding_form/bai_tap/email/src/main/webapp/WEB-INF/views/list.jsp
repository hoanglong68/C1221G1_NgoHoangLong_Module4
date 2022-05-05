<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Email</title>
</head>
<body>
<h1>Welcome</h1>
<c:forEach items="${emailList}" var="email">
    <h3>language: ${email.language}</h3>
    <h3>pageSize: ${email.pageSize}</h3>
    <h3>spamFilter: ${email.spamFilter}</h3>
    <h3>signature: ${email.signature}</h3>
</c:forEach>
<button><a href="/settings">Show List Email</a></button>
</body>
</html>
