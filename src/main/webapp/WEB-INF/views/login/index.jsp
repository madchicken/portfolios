<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Login Page</title>
    </head>
    <body>
        <h2>Login</h2>

        <div id="content">
            <c:if test="${not empty error}">
                <p class="error">${error}</p> 
            </c:if>
            <form action="${root}/login/login" method="post" class="well">
                <label for="email">Email
                    <input type="text" class="span3" placeholder="john@something.com" name="email" id="email"/>
                </label>
                <label for="password">Password
                    <input type="password" class="span3" placeholder="secret" name="password" id="password"/>
                </label>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <p><a href="${root}/registration">Not yet registered?</a></p>
            <p><a href="${root}/user">list users</a></p>

        </div>
    </body>
</html>
