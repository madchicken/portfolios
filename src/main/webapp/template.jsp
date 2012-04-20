<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title><sitemesh:write property='title'/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="${contextRoot}/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <script src="${contextRoot}/js/jquery.js"></script>
        <link href="${contextRoot}/css/bootstrap-responsive.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="${contextRoot}/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextRoot}/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextRoot}/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${contextRoot}/ico/apple-touch-icon-57-precomposed.png">
    <sitemesh:write property='head'/>
</head>

<body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">What I do</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active"><a href="${root}/">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    <ul class="nav pull-right">
                        <li id="fat-menu" class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-home icon-white"></i> Account <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <c:choose>
                                    <c:when test="${not empty user}">
                                        <li><a href="${root}/dashboard"><i class="icon-folder-open"></i> Dashboard</a></li>
                                        <li><a href="${root}/user/profile/${user.id}"><i class="icon-user"></i> Your profile</a></li>
                                        <li class="divider"></li>
                                        <li><a href="${root}/logout/logout"><i class="icon-share"></i> Logout</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${root}/login">Login</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>

    <div class="container">

        <sitemesh:write property='body'/>  
        <hr>

        <footer>
            <p>&copy; RedOddity Company 2012</p>
        </footer>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="${contextRoot}/js/bootstrap.js"></script>

</body>
</html>
