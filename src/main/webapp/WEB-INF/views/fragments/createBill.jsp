<form action="Controller" method="post" name = "bill_create">
    <select name="cardId">
        <c:forEach items="${user.getCards()}" var="card">
            <option value="<c:out value="${card.getId()}"/>">
                <c:out value="${card.getNumber()}"/>
            </option>
        </c:forEach>
    </select>
    <select name="toClientId">
        <c:forEach items="${usersList}" var="user">
            <option value="<c:out value="${user.getId()}"/>">
                <c:out value="${user.getFirstName()}"/>
                <c:out value="${user.getSecondName()}"/>
            </option>
        </c:forEach>
    </select>
    <input type="text" name="amount" placeholder="amount"/>">
    <input type="hidden" name="command" value="CREATE_BILL"/>
    <button type="submit" name="command" value="create">create</button>
</form>