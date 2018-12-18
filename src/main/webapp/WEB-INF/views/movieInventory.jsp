<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<script>
    $(document).ready(function () {
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            'lengthMenu': [[5, 10, 20, 50, -1], [5, 10, 20, 50, 'All']],
            'oSearch' : {'sSearch': searchCondition}
        })
    })
</script>

<div class="container">

    <div class="page-header">
        <h1>Movies Inventory</h1>

        <p class="lead">This is the movie inventory.</p>
    </div>

    <table class="table table-striped">
        <thead class="thead-light">
            <tr>
                <th>Photo Thumb</th>
                <th>Movie Title</th>
                <th>Director</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td><img src="<c:url value="/resources/images/${movie.movieId}.png" />" alt="image"
                             style="width: 100%;"/></td>
                    <td>${movie.movieTitle}</td>
                    <td>${movie.movieDirector}</td>
                    <td>${movie.moviePrice}</td>
                    <td>
                        <a href="<spring:url value="/movie/viewMovie/${movie.movieId}" />">
                            <i class="fas fa-info-circle"></i>
                        </a>
                        <a href="<spring:url value="/admin/movie/deleteMovie/${movie.movieId}" />">
                            <i class="fas fa-times"></i>
                        </a>
                        <a href="<spring:url value="/admin/movie/editMovie/${movie.movieId}" />">
                            <i class="fas fa-edit"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="<spring:url value="/admin/movie/addMovie" />" class="btn btn-primary">Add Movie</a>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>