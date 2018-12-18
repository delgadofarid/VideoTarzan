<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron" style="margin-top: 20px;">
            <div class="container">
                <h1 class="alert alert-danger">Checkout cancelled!</h1>

                <p>Your checkout process is cancelled. You may continue booking.</p>
            </div>
        </div>
    </section>
    <section class="container">
        <p><a href="<c:url value="/movie/movieList" />" class="btn btn-primary">OK</a></p>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>