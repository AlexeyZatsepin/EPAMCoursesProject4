<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="../../styles/main.css" rel="stylesheet" type="text/css">
    <title>
        Profile
    </title>
</head>
<body>
<c:out value="${user.getFirstName()}"/>
<c:out value="${user.getSecondName()}"/>
<c:out value="${user.getMobileNumber()}"/>
<c:out value="${user.getAdress()}"/>
<c:out value="${user.getEmail()}"/>
<c:forEach items="user.getCards()" var="card">
    <c:out value="${card}"/>
</c:forEach>
</body>
</html>
