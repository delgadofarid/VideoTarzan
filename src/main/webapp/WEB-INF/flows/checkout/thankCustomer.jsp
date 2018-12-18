<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron" style="margin-top: 20px;">
            <div class="container">
                <h1>Thank you for booking movies with us!</h1>

                <p>We will keep these items booked for 48 horas from now, please come and get the movies in the store
                    before expiration date.</p>
                <p>If for some reason you can not come, you can always call us on +1 9999999999.</p>
            </div>
        </div>
    </section>
    <section class="container">
        <p><a href="<c:url value="/" />" class="btn btn-primary">OK</a></p>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>