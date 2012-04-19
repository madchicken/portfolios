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
          <a class="brand" href="#">Project name</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="${root}/dashboard">Dashboard</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
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
    <script src="${contextRoot}/js/jquery.js"></script>
    <script src="${contextRoot}/js/bootstrap-transition.js"></script>
    <script src="${contextRoot}/js/bootstrap-alert.js"></script>
    <script src="${contextRoot}/js/bootstrap-modal.js"></script>
    <script src="${contextRoot}/js/bootstrap-dropdown.js"></script>
    <script src="${contextRoot}/js/bootstrap-scrollspy.js"></script>
    <script src="${contextRoot}/js/bootstrap-tab.js"></script>
    <script src="${contextRoot}/js/bootstrap-tooltip.js"></script>
    <script src="${contextRoot}/js/bootstrap-popover.js"></script>
    <script src="${contextRoot}/js/bootstrap-button.js"></script>
    <script src="${contextRoot}/js/bootstrap-collapse.js"></script>
    <script src="${contextRoot}/js/bootstrap-carousel.js"></script>
    <script src="${contextRoot}/js/bootstrap-typeahead.js"></script>

  </body>
</html>
