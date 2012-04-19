<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <div class="page-header">
            <h1>
                Dashboard
                <small>Here you'll find your own projects</small>
                <a class="btn btn-primary" href="${root}/project/create">Add Project</a>
            </h1>
        </div>
        <c:forEach items="${ownProjects}" var="ownProject">
            <div class="row">
                <div class="span12">
                    <h2>${ownProject.name}</h2>
                    <p>${ownProject.description}</p>
                    <p>
                        <a class="btn" href="#details">View Details</a>
                    </p>
                </div>
            </div>
        </c:forEach>
</body>
</html>
