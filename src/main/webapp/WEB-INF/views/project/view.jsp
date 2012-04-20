<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Details</title>
    </head>
    <body>
        <div class="page-header">
            <h1>
                ${project.name}
                <small>${project.url}</small>
                <a class="btn btn-warning" href="${root}/project/edit/${project.id}"><i class="icon-pencil icon-white"></i> Edit</a>
                <a class="btn btn-danger" href="${root}/project/delete/${project.id}"><i class="icon-trash icon-white"></i> Delete</a>
            </h1>
        </div>
        <ul class="thumbnails">
            <li class="span4">
                <a href="#" class="thumbnail">
                    <img src="http://placehold.it/360x268" alt="">
                </a>
            </li>
            <li class="span8">
                <p>${project.description}</p>
                <h3>Rating: </h3><h1>4.0</h1>
            </li>
        </ul>
        <a class="btn" href="${root}/dashboard">&larr; Go Back</a>
    </body>
</html>
