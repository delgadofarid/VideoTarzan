<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

    <div class="page-header">
        <h1>Register Customer</h1>

        <p class="lead">Please fill in your information bellow:</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/register" method="post"
               commandName="customer">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="customerName" cssStyle="color: #e4606d" />
            <form:input path="customerName" id="name" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="email">Email</label> <span style="color: #e4606d;">${emailMsg}</span> <form:errors
                path="customerEmail" cssStyle="color: #e4606d" />
            <form:input path="customerEmail" id="email" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="phone">Phone</label> <form:errors path="customerPhone" cssStyle="color: #e4606d" />
            <form:input path="customerPhone" id="phone" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="username">Username</label> <span style="color: #e4606d;">${usernameMsg}</span> <form:errors path="username" cssStyle="color: #e4606d" />
            <form:input path="username" id="username" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="password">Password</label> <form:errors path="password" cssStyle="color: #e4606d" />
            <form:password path="password" id="password" class="form-Control" />
        </div>
        <br><br>
        <input type="submit" value="Submit" class="btn btn-primary">
        <a href="<c:url value="/" />" class="btn btn-danger">Cancel</a>

    </form:form>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>