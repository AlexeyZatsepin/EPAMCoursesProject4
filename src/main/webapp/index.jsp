<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
    <c:when test="${user != null}">
        <jsp:forward page="jsp/userProfile.jsp"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="jsp/login.jsp"/>
    </c:otherwise>
</c:choose>