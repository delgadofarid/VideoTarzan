<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

    <div class="page-header">
        <h1>Add Movie</h1>

        <p class="lead">Fill the bellow information to add a movie:</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/admin/movie/addMovie" method="post"
               commandName="movie" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">Title</label> <form:errors path="movieTitle" cssStyle="color: #e4606d" />
            <form:input path="movieTitle" id="title" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="description">Description</label> <form:errors path="movieDescription" cssStyle="color: #e4606d" />
            <form:textarea path="movieDescription" id="description" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="cast">Cast</label> <form:errors path="movieCast" cssStyle="color: #e4606d" />
            <form:select id="cast" path="movieCast" multiple="true" items="${actors}" itemLabel="actorName" itemValue="actorId" cssClass="form-Control"/>
        </div>
        <div class="form-group">
            <label for="director">Director</label> <form:errors path="movieDirector" cssStyle="color: #e4606d" />
            <form:input path="movieDirector" id="director" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="price">Price</label> <form:errors path="moviePrice" cssStyle="color: #e4606d" />
            <form:input path="moviePrice" id="price" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="unitInStock">Unit in Stock</label> <form:errors path="unitInStock" cssStyle="color: #e4606d" />
            <form:input path="unitInStock" id="unitInStock" class="form-Control" />
        </div>
        <div class="form-group">
            <label for="movieImage">Upload Picture</label>
            <form:input id="movieImage" path="movieImage" type="file" cssClass="form-control-file" />
        </div>

        <br><br>
        <input type="submit" value="Submit" class="btn btn-primary">
        <a href="<c:url value="/admin/movieInventory" />" class="btn btn-danger">Cancel</a>

    </form:form>

</div><!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>