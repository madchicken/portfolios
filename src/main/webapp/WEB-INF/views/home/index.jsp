<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="it.redoddity.portfolios.model.Project"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolios Home Page</title>
    </head>
    <body>
        <div class="hero-unit">
            <h1>Latest Projects</h1>
            <p>What people do</p>
            <c:if test="${empty user}">
                <p>
                    <a class="btn btn-primary btn-large" href="${root}/login">
                    Login
                    </a>
                </p>
            </c:if>
        </div>        

        <div class="row">
            <c:if test="${not empty lastProjects}">
                <c:forEach items="${lastProjects}" var="project">
                    <div class="span10">
                        <h2>${project.name} by ${project.leader.email}</h2>
                        <p>${project.description}</p>
                        <p><a class="btn" href="#">View details »</a></p>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        
        <ul class="pager">
        
            <li class="previous">
                <a href="${root}/home/index?from=${from-10}">&larr; Older</a>
            </li>
       
            <li class="next">
                <a href="${root}/home/index?from=${from+10}">Newer &rarr;</a>
            </li>
        </ul>  
            
    </body>
</html>
