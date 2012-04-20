<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Registration Page</title>
    </head>
    <body>
        <h2>Profile</h2>
        <c:if test="${user.hasErrors}">
            <ul>
                <c:forEach items="${user.allErrors}" var="err">
                    <li>${err.field} ${err.defaultMessage}</li>
                </c:forEach>
            </ul>
        </c:if>

        <form action="${root}/user/update" method="post" class="well">
            <label for="nickname">Nickname
                <input type="text" class="span3" placeholder="superhero" name="nickName" id="nickname" value="${user.nickName}" disabled="disabled"/>
            </label>
            <label for="firstname">Firstname
                <input type="text" class="span3" placeholder="superhero" name="firstName" id="firstname" value="${user.firstName}"/>
            </label>
            <label for="lastname">Lastname
                <input type="text" class="span3" placeholder="superhero" name="lastName" id="lastname" value="${user.lastName}"/>
            </label>

            <label for="email">Email
                <input type="text" class="span3" placeholder="john@something.com" name="email" id="email" value="${user.email}"/>
            </label>
            <label for="password">Password
                <input type="password" class="span3" placeholder="super secret" name="password" id="password" value="${user.password}"/>
            </label>
            <label for="passwordConfirm">Confirm password
                <input id="passwordConfirm" name="passwordConfirm" type="password" placeholder="super secret" class="span3" value="${user.password}"/><br />
            </label>
            <input type="hidden" name="nickName" value="${user.nickName}"/>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="${root}/user/profile/${user.id}" class="btn">Cancel</a>
        </form>

    </body>
</html>
