<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <c:out value="${user.getFirstName()}"/>
        <c:out value="${user.getSecondName()}"/>
        | Contact us
    </title>
    <link href="../../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form method="POST" action="Controller" class="login-form">
            <input type="text" name="subject" placeholder="subject">
            <input type="text" name="message" placeholder="message">
            <input type="text" name="from" placeholder="your email">
            <input type="hidden" name="command" value="SEND_MAIL"/>
            <button type="submit" name="command" value="login">Send</button>
            <p class="message"><c:out value="${message}"/></p>
        </form>
    </div>
</div>
</body>
</html>
