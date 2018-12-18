<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/images/carousel/carousel-item-1.jpg" />"
                 alt="First slide">
            <div class="container">
                <div class="carousel-caption text-left">
                    <h1>Inception.</h1>
                    <p>A thief who steals corporate secrets through the use of dream-sharing technology is given the
                        inverse task of planting an idea into the mind of a CEO.</p>
                    <p><a class="btn btn-lg btn-primary" href="<c:url value="/register" />" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/images/carousel/carousel-item-2.jpg" />"
                 alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Bohemian Rhapsody.</h1>
                    <p>A chronicle of the years leading up to Queen's legendary appearance at the Live Aid (1985)
                        concert.</p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/images/carousel/carousel-item-3.jpg" />"
                 alt="Third slide">
            <div class="container">
                <div class="carousel-caption text-right">
                    <h1>Split.</h1>
                    <p>Three girls are kidnapped by a man with a diagnosed 23 distinct personalities. They must
                        try to escape before the apparent emergence of a frightful new 24th.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="rounded-circle"
                 src="http://icons.iconarchive.com/icons/danleech/simple/1024/imdb-icon.png"
                 alt="Generic placeholder image" width="140" height="140">
            <p>Online database of information related to films, television
                programs, home videos and video games, and internet streams, including cast, production crew and
                personnel biographies, plot summaries, trivia, and fan reviews and ratings.</p>
            <p><a class="btn btn-warning" href="https://www.imdb.com/" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="rounded-circle"
                 src="https://www.rottentomatoes.com/assets/pizza-pie/images/rtlogo.9b892cff3fd.png"
                 alt="Generic placeholder image" width="140" height="140" style="background-color: red;">
            <p> American review-aggregation website for film and television. The company was
                launched in August 1998 by three undergraduate students at the University of California, Berkeley:
                Senh Duong, Patrick Y. Lee, and Stephen Wang.</p>
            <p><a class="btn btn-danger" href="https://www.rottentomatoes.com/" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="rounded-circle"
                 src="https://i1.wp.com/media.boingboing.net/wp-content/uploads/2015/08/metacritic.gif"
                 alt="Generic placeholder image" width="140" height="140">
            <p>Metacritic is a website that aggregates reviews of media products: films, TV shows, music albums,
                video games, and formerly, books. For each product, the scores from each review are averaged (a
                weighted average).</p>
            <p><a class="btn btn-dark" href="https://www.metacritic.com/" role="button" target="_blank">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

</div>
<!-- /.container -->

<%@include file="/WEB-INF/views/template/footer.jsp" %>