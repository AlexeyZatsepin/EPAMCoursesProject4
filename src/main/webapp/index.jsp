<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
<form method="POST" action="Controller">
    Email <input type="text" name="email"><br>
    Password<input type="password" name="password"><br>
    <input type="hidden" name="command" value="LOG_IN"/>
    <input type="submit" name="command" value="login">
</form>

<br><%=request.getParameter("message")%><br>

</body>
</html>