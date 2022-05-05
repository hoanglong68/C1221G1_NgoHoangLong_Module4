<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song list</title>
</head>
<body>
<h1>Song List</h1>
<c:forEach items="${songList}" var="song">
    <p>nameSong: ${song.nameSong}</p>
    <p>nameSinger: ${song.nameSinger}</p>
    <p>typeSong: ${song.typeSong}</p>
    <p>path: ${song.path}</p>
</c:forEach>
<button><a href="/home">go to home</a></button>
</body>
</html>
