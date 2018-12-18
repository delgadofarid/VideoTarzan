<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

    <div class="page-header">
        <h1>Order</h1>

        <p class="lead">Order confirmation</p>
    </div>

    <div class="container">

        <div class="row">

            <form:form commandName="order">

                <div class="card col-10 col-sm-10 col-md-6 offset-1 offset-sm-1 offset-md-3">

                    <div class="text-center">
                        <h1>Receipt</h1>
                    </div>
                    <div class="row">
                        <div class="col-6 col-sm-6 col-md-6">
                            <strong>Pick Up at Store!</strong>
                        </div>
                    </div>
                    <div class="row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Movie</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.movie.movieTitle}</em></td>
                                        <td class="col-md-1 text-center">${cartItem.quantity}</td>
                                        <td class="col-md-1 text-center">${cartItem.movie.moviePrice}</td>
                                        <td class="col-md-1 text-center">${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total: </strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <input type="hidden" name="_flowExecutionKey">
                    <br><br>
                    <input type="submit" value="Submit" class="btn btn-primary"
                           name="_eventId_orderConfirmed"/>
                    <button class="btn btn-danger" name="_eventId_cancel">Cancel</button>

                </div>



            </form:form>

        </div>

    </div>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>