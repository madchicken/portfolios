<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Project</title>
    </head>
    <body>
    <c:if test="${requestScope.project.hasErrors}">
        <ul>
            <c:forEach items="${requestScope.project.allErrors}" var="err">
                <li>${err.field} ${err.defaultMessage}</li>
            </c:forEach>
        </ul>
    </c:if>
    <form class="form-horizontal" action="${root}/project/create" method="post">
        <fieldset>
            <legend>Add a new project</legend>
            <div class="control-group">
                <label class="control-label" for="name">Name:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="name" name="name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="description">Description:</label>
                <div class="controls">
                    <textarea class="input-large" id="description" name="description"></textarea>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tags">Tags:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="tags" name="tags">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="url">Url</label>
                <div class="controls">
                    <input type="text" class="input-large" id="url" name="url">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="thumbnailUrl">Thumbnail Url:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="thumbnailUrl" name="thumbnailUrl">
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-success"><i class="icon-plus icon-white"></i> Add Project</button>
                <a class="btn" href="${root}/dashboard"><i class="icon-arrow-left"></i> Cancel</a>
            </div>
        </fieldset>
    </form>
</body>
</html>
