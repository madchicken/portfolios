<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Project</title>
    </head>
    <body>
    <c:if test="${requestScope.project.hasErrors}">
        <ul>
            <c:forEach items="${requestScope.project.allErrors}" var="err">
                <li>${err.field} ${err.defaultMessage}</li>
            </c:forEach>
        </ul>
    </c:if>
    <form class="form-horizontal" action="${root}/project/update" method="post">
        <fieldset>
            <legend>Edit project</legend>
            <div class="control-group">
                <label class="control-label" for="name">Name:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="name" name="name" value="${project.name}">
                    <input type="hidden" class="input-large" name="id" value="${project.id}" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="description">Description:</label>
                <div class="controls">
                    <textarea class="input-large" id="description" name="description">${project.description}</textarea>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="tags">Tags:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="tags" name="tags" value="${project.tags}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="url">Url</label>
                <div class="controls">
                    <input type="text" class="input-large" id="url" name="url" value="${project.url}">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="thumbnailUrl">Thumbnail Url:</label>
                <div class="controls">
                    <input type="text" class="input-large" id="thumbnailUrl" name="thumbnailUrl" value="${project.thumbnailUrl}">
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-success"><i class="icon-ok icon-white"></i> Save Changes</button>
                <a class="btn" href="${root}/dashboard">&larr; Cancel</a>
            </div>
        </fieldset>
    </form>
</body>
</html>
