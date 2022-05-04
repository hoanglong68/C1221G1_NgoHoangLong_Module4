<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/4/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/result">
<%--    <input type="hidden" name="condiment" value="">--%>
    <input type="checkbox" name="condiment" value="lettuce">lettuce
    <input type="checkbox" name="condiment" value="tomato">tomato
    <input type="checkbox" name="condiment" value="mustard">mustard
    <input type="checkbox" name="condiment" value="sprouts">sprouts
    <input type="submit" value="save" name="save">
</form>
</body>
</html>
