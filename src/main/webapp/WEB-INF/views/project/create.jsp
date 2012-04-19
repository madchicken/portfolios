<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Project</title>
    </head>
    <body>
        <form class="form-horizontal" action="${root}/project/save" method="post">
            <fieldset>
                <legend>Add a new project</legend>
                <div class="control-group">
                    <label class="control-label" for="name">Name:</label>
                    <div class="controls">
                        <input type="text" class="input-large" id="name">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="description">Description:</label>
                    <div class="controls">
                        <textarea class="input-large" id="description"></textarea>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="tags">Tags:</label>
                    <div class="controls">
                        <input type="text" class="input-large" id="tags">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="url">Url</label>
                    <div class="controls">
                        <input type="text" class="input-large" id="url">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="thumbnailUrl">Thumbnail Url:</label>
                    <div class="controls">
                        <input type="text" class="input-large" id="thumbnailUrl">
                    </div>
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Add Project</button>
                </div>
            </fieldset>
        </form>
    </body>
</html>
