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
        
        <form action="${root}/registration/register" method="post" class="f-wrap-1">
                            <h1>Please, fill in the information in the form below:</h1>
                            <fieldset>
                                <label for="firstname"><b><span class="req">*</span>Firstname:</b>
                                <input id="firstname" name="firstName" type="text" class="f-name" tabindex="1" /><br />
                                </label>                        
                                <label for="lastname"><b><span class="req">*</span>Lastname:</b>
                                <input id="lastname" name="lastName" type="text" class="f-name" tabindex="1" /><br />
                                </label>    
                                 <label for="nickname"><b><span class="req">*</span>Nickname:</b>
                                <input id="nickname" name="nickName" type="text" class="f-name" tabindex="1" /><br />
                                </label>                        
                                <label for="email"><b><span class="req">*</span>Email:</b>
                                <input id="email" name="email" type="text" class="f-email" tabindex="1" /><br />
                                </label>                        
                                <label for="password"><b><span class="req">*</span>Password:</b>
                                <input id="password" name="password" type="text" class="f-password" tabindex="2" /><br />
                                </label>                        
                                <label for="passwordConfirm"><b><span class="req">*</span>Confirm password:</b>
                                <input id="passwordConfirm" name="passwordConfirm" type="text" class="f-password" tabindex="2" /><br />
                                </label>                        
                            </fieldset>
                            <div class="f-submit-wrap">
                                <input type="submit" value="Register!" class="f-submit"/>
                            </div>
                        </form>
         <p><a href="${root}/login">Login</a></p>
    </body>
</html>
