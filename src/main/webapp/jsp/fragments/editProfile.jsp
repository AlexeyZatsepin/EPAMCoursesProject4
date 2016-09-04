<c:out value="${user}"/>
<form action="Controller" method="post" name = "edit_profile">
    <input type="text" name="mobile_number" placeholder="<c:out value="${user.getMobileNumber()}"/>">
    <input type="text" name="adress" placeholder="<c:out value="${user.getAdress()}"/>">
    <input type="text" name="email" placeholder="<c:out value="${user.getEmail()}"/>">
    <input type="password" name="old_password" placeholder="type old password">
    <input type="password" name="new_password" placeholder="type new password">
    <input type="hidden" name="command" value="EDIT_PROFILE"/>
    <button type="submit" name="command" value="login">edit</button>
</form>