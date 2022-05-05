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
<form:form>
    <form:input type="text" path="nameSong"/>
    <form:input type="text" path="nameSinger"/>
    <form:select path="typeSong">
        <option value="tre">tre</option>
        <option value="song">song</option>
        <option value="vang">vang</option>
        <option value="thieu nhi">thieu nhi</option>
    </form:select>
    <form:input type="text" path="path"/>
    <input type="submit" value="update">
</form:form>
<button><a href="/list">go to list</a></button>
</body>
</html>
