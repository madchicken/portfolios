<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="span3">
                <a href="#" class="thumbnail">
                    <img src="http://placehold.it/360x268" alt="">
                </a>
            </li>
            <li class="span8">
                <p>${project.description}</p>
            </li>
        </ul>
        <c:if test="${not empty user}">
            <div class="btn-toolbar" style="margin-bottom: 9px">
                <div class="btn-group">
                    <a class="btn star" href="#" id="star1"><i class="icon-star-empty"></i></a>
                    <a class="btn star" href="#" id="star2"><i class="icon-star-empty"></i></a>
                    <a class="btn star" href="#" id="star3"><i class="icon-star-empty"></i></a>
                    <a class="btn star" href="#" id="star4"><i class="icon-star-empty"></i></a>
                    <a class="btn star" href="#" id="star5"><i class="icon-star-empty"></i></a>
                </div>
            </div>
        </c:if>

        <a class="btn" href="${root}/dashboard">&larr; Go Back</a>
        <script type="text/javascript">
            var vote = ${vote};
            
                $(function() {
                    var resetStars = function() {
                        for(i = 1; i < vote+1;i++){
                            $("#star"+i+" i").removeClass('icon-star-empty').addClass('icon-star');
                        }
                        for(i = vote+1; i < 6;i++){
                            $("#star"+i+" i").removeClass('icon-star').addClass('icon-star-empty');
                        }
                    };
                    
                    resetStars();
                    $('.star').mouseover( function() {
                        $this = $(this);
                        var id = $this.attr('id');
                        var value = id.substr('star'.length, 1);
                        var to = new Number(value)+1;
                        for(i = 1; i < to;i++){
                            $("#star"+i+" i").removeClass('icon-star-empty').addClass('icon-star');
                        }
                        for(i = to; i < 6;i++){
                            $("#star"+i+" i").removeClass('icon-star').addClass('icon-star-empty');
                        }
                    });
                    $('.star').mouseout( function() {
                        resetStars();
                    });                    
                    $('.star').click(function(){
                        var id = $this.attr('id');
                        var value = id.substr('star'.length, 1);
                        $.ajax({
                            url: "${root}/vote/vote",      
                            dataType: 'json',
                            type: 'POST',
                            data: {
                                value: value,
                                userId: "${user.id}",
                                projectId: "${project.id}"
                            },
                            success: function() {
                                vote = new Number(value);
                                resetStars();
                            },
                            error: function() {
                                resetStars();
                            }
                        })

                    });
                });
        </script>
    </body>
</html>
