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
        <h1>All Movies</h1>

        <p class="lead">Checkout all the awesome movies available now!</p>
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
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>