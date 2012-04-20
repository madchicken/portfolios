<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Registration Page</title>
    </head>
    <body>
    <div class="container-fluid">
    <div class="row-fluid">
    <div class="span2">
    <!--Sidebar content-->
    <img src="${theUser.gravatarURL}" title="Avatar"/>
    </div>
    <div class="span10">
    <!--Body content-->
<h2>${theUser.nickName}'s Profile</h2>

        

        
    <div class="row-fluid">
        <div class="span4">First name</div>
        <div class="span8">${theUser.firstName}</div>
    </div>
    <div class="row-fluid">
        <div class="span4">Last name</div>
        <div class="span8">${theUser.lastName}</div>
    </div>
    <div class="row-fluid">
        <div class="span4">Email</div>
        <div class="span8">${theUser.email}</div>
    </div>
        <c:if test="${theUser.nickName eq user.nickName}">
            <a href="${root}/user/edit" class="btn btn-primary">Update your profile </a>
            
                
        </c:if>    
    </div>
    </div>
    </div>        
        

    </body>
</html>
