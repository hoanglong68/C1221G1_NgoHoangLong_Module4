<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <c:forEach var="spice" items="${condimentlist}">
            <p>${spice}</p>
    </c:forEach>
</body>
</html>
