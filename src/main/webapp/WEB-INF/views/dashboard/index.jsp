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
                <small>Welcome ${user.nickName}, here you'll find your own projects</small>
                <a class="btn btn-success" href="${root}/project/newproject"><i class="icon-plus icon-white"></i> Add Project</a>
            </h1>
            
        </div>
        <c:forEach items="${ownProjects}" var="ownProject">
            <div class="row">
                <div class="span12">
                    <h2><a href="${root}/project/view/${ownProject.id}">${ownProject.name}</a></h2>
                    <p>${ownProject.description}</p>
                    <p>
                        <a class="btn" href="${root}/project/view/${ownProject.id}"><i class="icon-eye-open"></i>View Details</a>
                    </p>
                </div>
            </div>
        </c:forEach>
</body>
</html>
