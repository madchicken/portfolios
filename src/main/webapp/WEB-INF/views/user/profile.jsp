<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Registration Page</title>
    </head>
    <body>
        <div class="page-header">
            <h1>
                <img src="${theUser.gravatarURL}" alt="user avatar">
                ${theUser.nickName}'s Profile&rarr;
                <small>${theUser.firstName} ${theUser.lastName}</small>
            </h1>

        </div>
        <strong>Firstname:</strong>
        <p>${theUser.firstName}</p>
        <br />
        <strong>LastName</strong>
        <p>${theUser.lastName}</p>
        <br />
        <strong>Email</strong>
        <p>${theUser.email}</p>
        <br />
        <c:if test="${theUser.nickName eq user.nickName}">
            <a href="${root}/user/edit" class="btn btn-primary">Update profile</a>
        </c:if>    

    </body>
</html>
