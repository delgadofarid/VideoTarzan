<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

    <div class="page-header">
        <h1>Administrator Page</h1>

        <p class="lead">This is the administrator page</p>
    </div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome ${pageContext.request.userPrincipal.name} | <form action="<c:url value="/perform_logout" />" method="post" style="display: inline-block;"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><input class="btn-link" type="submit" value="Logout"></form>
        </h2>
    </c:if>

    <h3>
        <a href="<c:url value="/admin/movieInventory" />">Movies Inventory</a>
    </h3>

    <p>Here you can view, check and modify the movie inventory</p>

    <h3>
        <a href="<c:url value="/admin/customer" />">Customer Management</a>
    </h3>

    <p>Here you can view the customer information</p>

    <h3>
        <a href="<c:url value="/admin/order" />">Order Management</a>
    </h3>

    <p>Here you can view the order information</p>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>