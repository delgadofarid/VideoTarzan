<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

    <div class="page-header">
        <h1>Movie Detail</h1>

        <p class="lead">Here is the detail information of the movie!</p>
    </div>

    <div class="container" ng-app="cartApp">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${movie.movieId}.png" />" alt="image"
                         style="width: 100%;"/>
            </div>
            <div class="col-md-5">
                <h3>${movie.movieTitle}</h3>
                <p>${movie.movieDescription}</p>
                <p><strong>Cast: </strong>
                    <ul>
                        <c:forEach items="${movie.movieCast}" var="actor">
                            <li>${actor.actorName}</li>
                        </c:forEach>
                    </ul>
                </p>
                <p><strong>Director: </strong>${movie.movieDirector}</p>
                <p><strong>Unit in stock: </strong>${movie.unitInStock}</p>
                <p><strong>${movie.moviePrice} COP</strong></p>
                <br>
                <c:set var="role" scope="page" value="${param.role}" />
                <c:set var="url" scope="page" value="/movie/movieList" />
                <c:if test="${role = 'admin'}">
                    <c:set var="url" scope="page" value="/admin/movieInventory" />;
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}" />" class="btn btn-outline-primary">Back</a>
                    <a href="#" class="btn btn-warning btn-lg" ng-click="addToCart('${movie.movieId}')">
                        <i class="fas fa-cart-plus"></i> Book Now</a>
                    <a href="<c:url value="/customer/cart" />" class="btn btn-outline-primary">
                        <i class="fas fa-shopping-cart"></i> View Cart</a>
                </p>

            </div>
        </div>
    </div>

</div><!-- /.container -->
<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>