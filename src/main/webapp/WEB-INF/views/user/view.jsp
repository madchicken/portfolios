<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Profile Page</title>
    </head>
    <body>
        <h2>Profile</h2>


        <ul>
            <li>
                <dl>
                    <dt class="desc"> ${user.nickName}</dt>
                    <dd class="desc"> ${user.firstName}   </dd>
                    <dd class="desc"> ${user.lastName}   </dd>
                    <dd class="desc"> ${user.email}   </dd>
                </dl>
            </li>
        </ul>


    </body>
</html>
