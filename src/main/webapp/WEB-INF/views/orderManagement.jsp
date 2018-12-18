<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<script>
    $(document).ready(function () {
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            'lengthMenu': [[1, 2, 3, 5, 10, -1], [1, 2, 3, 5, 10, 'All']],
            'oSearch' : {'sSearch': searchCondition}
        })
    })
</script>

<div class="container">

    <div class="page-header">
        <h1>Orders Management Page</h1>

        <p class="lead">This is the orders management page</p>
    </div>

    <table class="table table-striped">
        <thead class="thead-light">
        <tr>
            <th>#</th>
            <th>Customer</th>
            <th>Order Date</th>
            <th>Order Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerOrderList}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.customer.customerName}</td>
                <td>${order.orderDate}</td>
                <td style="white-space: pre-line; text-align: left; overflow: auto; text-overflow: inherit;">
                        ${order.orderDetails}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>