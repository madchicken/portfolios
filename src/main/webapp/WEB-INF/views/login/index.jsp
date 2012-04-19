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
                    <form action="${root}/login/login" method="post" class="f-wrap-1">
                        <div class="req"><b>*</b> Indicates newFolderrequired field</div>
                        <fieldset>
                        <h3>Please login to our system</h3>
                        <label for="email"><b><span class="req">*</span>Email:</b>
                        <input id="email" name="email" type="text" class="f-email" tabindex="1" /><br />
                        </label>                        
                        <label for="password"><b><span class="req">*</span>Password:</b>
                        <input id="password" name="password" type="text" class="f-password" tabindex="2" /><br />
                        </label>                        
                        <div class="f-submit-wrap">
                        <input type="submit" value="Login" class="f-submit"/>
                        </div>
                        </fieldset>
                    </form>
                    <p><a href="${root}/registration">Not yet registered?</a></p>
                    
                </div>
    </body>
</html>
