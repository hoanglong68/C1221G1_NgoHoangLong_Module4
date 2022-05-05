<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/5/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song Upload</title>
</head>
<body>
<h1 style="color: green">${message}</h1>
<form:form modelAttribute="song" method="post" action="home">
    <div>
        name song:
        <form:input type="text" path="nameSong"/>
    </div>
    <div>
        name singer:
        <form:input type="text" path="nameSinger"/>
    </div>
    <div>
        type song:
        <form:select path="typeSong">
            <option value="tre">tre</option>
            <option value="song">song</option>
            <option value="vang">vang</option>
            <option value="thieu nhi">thieu nhi</option>
        </form:select>
    </div>
    <div>
        path:
        <form:input type="text" path="path"/>
    </div>
    <input type="submit" value="update">
</form:form>
<button><a href="/list">go to list</a></button>
</body>
</html>
