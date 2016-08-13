<table>
    <caption>Your cards</caption>
    <thead>
    <th scope="col">Number</th>
    <th scope="col">Provider</th>
    <th scope="col">Expires End</th>
    <th scope="col">Amount</th>
    </thead>
    <tbody>
    <c:forEach items="${user.getCards()}" var="card">
        <tr>
            <td><c:out value="${card.getNumber()}"/></td>
            <td><c:out value="${card.getProvider()}"/></td>
            <td><c:out value="${card.getExpiresEnd()}"/></td>
            <td><c:out value="${card.getId()}"/></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <th scope="row">Total</th>
    <td colspan="3">120$</td>
    </tfoot>
</table>

