<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron" style="margin-top: 20px;">
            <div class="container">
                <h1>Not enough items in stock.</h1>
            </div>
        </div>
    </section>
    <section class="container">
        <p><a href="<c:url value="/movie/movieList" />" class="btn btn-primary">Movies</a></p>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>