<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Profile Page</title>
    </head>
    <body>
        <h2>List Users</h2>

        <ol>
            <c:forEach items="${allUsers}" var="user">
                <li>
                    <dl>
                        <dt><a href="${root}/user/view/${user.id}">${user.nickName}</a></dt>
                        <dd class="desc">${user.email}</dd>
                        <dd></dd>
                    </dl>
                </li>
            </c:forEach>
        </ol>


        <p><a href="${root}/login">Login here</a></p>
    </body>
</html>
