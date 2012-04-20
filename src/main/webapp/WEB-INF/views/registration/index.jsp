<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Registration Page</title>
    </head>
    <body>
        <h2>Registration</h2>
        <c:if test="${requestScope.user.hasErrors}">
            <ul>
                <c:forEach items="${requestScope.user.allErrors}" var="err">
                    <li>${err.field} ${err.defaultMessage}</li>
                </c:forEach>
            </ul>
        </c:if>

        <form action="${root}/registration/register" method="post" class="well">
            <label for="nickname">Nickname
                <input type="text" class="span3" placeholder="superhero" name="nickName" id="nickname" value="${param.nickname}"/>
            </label>
            <label for="email">Email
                <input type="text" class="span3" placeholder="john@something.com" name="email" id="email" value="${param.email}"/>
            </label>
            <label for="password">Password
                <input type="password" class="span3" placeholder="super secret" name="password" id="password" />
            </label>
            <label for="passwordConfirm">Confirm password
                <input id="passwordConfirm" name="passwordConfirm" type="password" placeholder="super secret" class="span3" /><br />
            </label>                        
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        <p><a href="${root}/login">Login here</a></p>
    </body>
</html>
