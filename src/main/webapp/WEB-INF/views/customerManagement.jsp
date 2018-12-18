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
        <h1>Customer Management Page</h1>

        <p class="lead">This is the customer management page</p>
    </div>

    <table class="table table-striped">
        <thead class="thead-light">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Username</th>
            <th>Enabled</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.customerName}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerPhone}</td>
                <td>${customer.username}</td>
                <td>${customer.enabled}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>