<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Cart</h1>
                <p>All the selected movies ready to book!.</p>
            </div>
        </div>
    </section>
    <section class="container" ng-app="cartApp">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-outline-danger float-left" ng-click="clearCart()">
                    <i class="fas fa-trash-alt"></i> Clear cart</a>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Movie</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat = "item in cart.cartItems">
                    <td>{{item.movie.movieTitle}}</td>
                    <td>{{item.movie.moviePrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td>
                        <a href="#" ng-click="removeFromCart(item.movie.movieId)" class="btn btn-danger btn-sm">
                            <i class="fas fa-trash-alt"></i> remove</a>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>Grand Total</td>
                    <td>{{grandTotal}}</td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>

        <a href="<c:url value="/movie/movieList" />" class="btn btn-primary"> Continue Booking</a>
        <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success float-right">
            <i class="fas fa-shopping-cart"></i> Checkout</a>
    </section>
</div>
<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>