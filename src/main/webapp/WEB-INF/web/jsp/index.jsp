<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <!-- <spring:url value="/resources" var="resourcesFolder" /> -->

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- <link rel="apple-touch-icon" href="apple-touch-icon.png"> -->

        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->


        <!--For Plugins external css-->
        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/plugins.css" />
        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/lato-webfont.css" />
        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/magnific-popup.css">



        <!--Theme custom css -->
        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="/Test/resources/theme/bazinger/assets/css/responsive.css" />

        <script src="/Test/resources/theme/bazinger/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

        <script src="/Test/resources/theme/bazinger/assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="/Test/resources/theme/bazinger/assets/js/vendor/bootstrap.min.js"></script>


        <script src="http://maps.google.com/maps/api/js"></script>
        <script src="/Test/resources/theme/bazinger/assets/js/gmaps.min.js"></script>

        <script src="/Test/resources/theme/bazinger/assets/js/jquery.magnific-popup.js"></script>

        <script src="/Test/resources/theme/bazinger/assets/js/plugins.js"></script>
        <script src="/Test/resources/theme/bazinger/assets/js/main.js"></script>

        <script src="/Test/resources/theme/bazinger/assets/js/bootstable.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

		<div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img src="/Test/resources/theme/bazinger/assets/images/logo.png" alt="" /></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#home">Home</a></li>
                        <li><a href="#features">Features</a></li>
                        <li><a href="#gallery">Gallery</a></li>
                        <li><a href="#video">Video</a></li>
                        <li><a href="#price">Prices</a></li>
                        <li><a href="#testimonial">Testimonials</a></li>
                        <li><a href="#download">Download</a></li>
                        <li><a href="#contact">Contact</a></li>

                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <!--Home page style-->
        <header id="home" class="home">

            <div class="container">

                <div class="row">

                    <div class="col-md-6 col-md-offset-6 col-sm-12 col-xs-12">
                        <div class="home-content sections">

                            <h1>Simple, Beautiful <span>and Amazing</span></h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eget nunc vitae tellus luctus ullamcorper. Nam porttitor ullamcorper felis at convallis. Aenean ornare vestibulum nisi fringilla lacinia. Nullam pulvinar sollicitudin velit id laoreet. Quisque non rhoncus sem.</p>

                            <a target="_blank" href="#"><button class="btn btn-default btn-lg">Download</button></a>
                            <a target="_blank" href="#"><button class="btn btn-primary btn-lg">Learn More</button></a>

                            <div class="available">
                                <p>
                                    Available on :
                                    <a href="#"><i class="fa fa-apple"></i></a>
                                    <a href="#"><i class="fa fa-android"></i></a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>

            </div>

        </header>

        <!-- Sections -->
        <section id="features" class="sections lightbg">
            <div class="container text-center">

                <div class="heading-content">
                    <h3>summarise the features</h3>
                    <h5>summarise what your product is all about</h5>
                </div>

                <!-- Example row of columns -->
                <div class="row">

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="features-content">
                            <i class="fa fa-bookmark-o"></i>
                            <h5>Attractive Layout</h5>
                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="features-content">
                            <i class="fa fa-tablet"></i>
                            <h5>Fresh Design</h5>
                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="features-content">
                            <i class="fa fa-comments"></i>
                            <h5>Multipurpose</h5>
                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="features-content">
                            <i class="fa fa-comment-o"></i>
                            <h5>Easy to customize</h5>
                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>
                        </div>
                    </div>

                </div>
            </div> <!-- /container -->
        </section>

        <!-- Sections -->
        <section id="gallery" class="sections">
            <div class="container text-center">

                <div class="heading-content">
                    <h3>show the gallery</h3>
                    <h5>summarise what your product is all about </h5>
                </div>

                <!-- Example row of columns -->
                <div class="row">



                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="gallery-item">
                            <div class="gallery">
                                <img src="/Test/resources/theme/bazinger/assets/images/gallery/1.png" alt="" />
                                <h6>My Gallery 1</h6>

                                <div class="img-overlay"></div>

                                <div class="gallery-icon">
                                    <a class="gallery-img" href="/Test/resources/theme/bazinger/assets/images/gallery/1.png ">View More</a>

                                </div>
                            </div>

                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>

                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="gallery-item">
                            <div class="gallery">
                                <img src="/Test/resources/theme/bazinger/assets/images/gallery/2.png" alt="" />
                                <h6>My Gallery 2</h6>

                                <div class="img-overlay"></div>

                                <div class="gallery-icon">

                                    <a class="gallery-img" href="/Test/resources/theme/bazinger/assets/images/gallery/1.png">View More</a>
                                </div>
                            </div>

                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>

                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="gallery-item">
                            <div class="gallery">
                                <img src="/Test/resources/theme/bazinger/assets/images/gallery/3.png" alt="" />
                                <h6>My Gallery 3</h6>

                                <div class="img-overlay"></div>

                                <div class="gallery-icon">

                                    <a class="gallery-img" href="/Test/resources/theme/bazinger/assets/images/gallery/1.png">View More</a>
                                </div>
                            </div>

                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>

                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="gallery-item">
                            <div class="gallery">
                                <img src="/Test/resources/theme/bazinger/assets/images/gallery/4.png" alt="" />
                                <h6>My Gallery 4</h6>

                                <div class="img-overlay"></div>

                                <div class="gallery-icon">
                                    <a class="gallery-img" href="/Test/resources/theme/bazinger/assets/images/gallery/1.png">View More</a>
                                </div>

                            </div>

                            <p>Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.</p>

                        </div>
                    </div>



                </div>
            </div> <!-- /container -->
        </section>

        <!-- Sections -->
        <section id="video" class="video">
            <div class="overlay sections">
                <div class="container text-center">
                    <!-- Example row of columns -->
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
                            <div class="video-content">

                                <a href="http://www.youtube.com/embed/ee1_2gA8UZY?autoplay=1&amp;.)wmode=opaque&amp;.)fs=1" class="youtube-media"><i class="fa fa-play"></i></a>
                                <h1>Watch the best Technology in <span>Action</span></h1>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eget nunc vitae tellus luctus ullamcorper. Nam porttitor ullamcorper felis at convallis. Aenean ornare vestibulum nisi fringilla lacinia. Nullam pulvinar sollicitudin velit id laoreet. Quisque non rhoncus sem.</p>

                            </div>
                        </div>
                    </div>
                </div> <!-- /container -->
            </div>
        </section>

        <!-- Sections -->
        <section id="price" class="sections">
            <div class="container text-center">

                <div class="heading-content">
                    <h3>choose your price</h3>
                    <h5>summarise what your product is all about </h5>
                </div>

                <!-- Example row of columns -->
                <div class="row">

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="price-category basic">
                            <h4>Basic Package</h4>
                            <h2>20$</h2>
                            <ul>
                                <li>Nullam suscipit vitae</li>
                                <li>Etiam faucibus</li>
                                <li>Vivamus viverra</li>

                            </ul>
                            <a href="#" class="btn-price">Purchase</a>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="price-category professional">
                            <h4>Professional Package</h4>
                            <h2>25$</h2>
                            <ul>
                                <li>Nullam suscipit vitae</li>
                                <li>Etiam faucibus</li>
                                <li>Vivamus viverra</li>
                                <li>Praesent pharetra</li>
                            </ul>
                            <a href="#" class="btn-price">Purchase</a>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="price-category advance">
                            <h4>Advanced Package</h4>
                            <h2>30$</h2>
                            <ul>
                                <li>Nullam suscipit vitae</li>
                                <li>Etiam faucibus</li>
                                <li>Vivamus viverra</li>

                            </ul>
                            <a href="#" class="btn-price">Purchase</a>
                        </div>
                    </div>

                </div>
            </div> <!-- /container -->
        </section>

        <!-- Sections -->
        <section id="testimonial" class="sections lightbg">
            <div class="container text-center">

                <div class="heading-content">
                    <h3>Testimonials</h3>
                </div>

                <!-- Example row of columns -->
                <div class="row">

                    <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">

                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="false">
                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner" role="listbox">

                                <div class="item active">

                                    <div class="col-md-4">
                                        <div class="testimonial-photo">
                                            <img src="/Test/resources/theme/bazinger/assets/images/gallery/2.png" alt="" />
                                        </div>
                                    </div>

                                    <div class="col-md-8">
                                        <div class="testimonial-content">
                                            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit.Praesent lobortis lectus eget libero blandit venenatis.In blandit tortor vel congue malesuada. Suspendisse. molestie lobortis lorem dignissim pretium.</p>
                                            <h6><strong>John Doe <br />from some company</strong></h6>
                                        </div>
                                    </div>

                                </div>

                                <div class="item">

                                    <div class="col-md-4">
                                        <div class="testimonial-photo">
                                            <img src="/Test/resources/theme/bazinger/assets/images/gallery/2.png" alt="" />
                                        </div>
                                    </div>

                                    <div class="col-md-8">
                                        <div class="testimonial-content">
                                            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit.Praesent lobortis lectus eget libero blandit venenatis.In blandit tortor vel congue malesuada. Suspendisse. molestie lobortis lorem dignissim pretium.</p>
                                            <h6><strong>John Doe <br />from some company</strong></h6>
                                        </div>
                                    </div>

                                </div>

                                <div class="item">

                                    <div class="col-md-4">
                                        <div class="testimonial-photo">
                                            <img src="/Test/resources/theme/bazinger/assets/images/gallery/2.png" alt="" />
                                        </div>
                                    </div>

                                    <div class="col-md-8">
                                        <div class="testimonial-content">
                                            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit.Praesent lobortis lectus eget libero blandit venenatis.In blandit tortor vel congue malesuada. Suspendisse. molestie lobortis lorem dignissim pretium.</p>
                                            <h6><strong>John Doe <br />from some company</strong></h6>
                                        </div>
                                    </div>

                                </div>


                            </div>


                        </div>


                    </div>

                </div>


            </div> <!-- /container -->
        </section>

        <!-- Sections -->
        <section id="download" class="section colorsbg download">
            <div class="container text-center">

                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="download-content">
                            <h1>Do you Like this app?</h1>
                            <button class="btn btn-primary">Download Now</button>
                        </div>
                    </div>
                </div>
            </div> <!-- /container -->
        </section>

        <!-- Sections -->
        <section id="contact">

            <div id="map"></div>

            <div class="container text-center">

                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-4 col-md-offset-4 col-sm-12 col-xs-12">
                        <div class="contact-form-area">
                            <form>
                                <h3>Contact</h3>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name">
                                </div>

                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Your Email">
                                </div>

                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Subject">
                                </div>

                                <div class="form-group">
                                    <textarea class="form-control" rows="7" placeholder="Message"></textarea>
                                </div>

                                <button type="submit" class="btn btn-primary contact-btn">SEND</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div> <!-- /container -->
        </section>

        <div class="scroll-top">

            <div class="scrollup">
                <i class="fa fa-angle-double-up"></i>
            </div>

        </div>


        <!--Footer-->
        <footer id="footer" class="footer colorsbg">
            <div class="container">
                <div class="row">

                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="copyright text-left">
                            <p>Made with <i class="fa fa-heart"></i> by <a href="http://bootstrapthemes.co"> Bootstrap Themes </a>2016. All rights reserved.</p>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="copyright text-right">
                            <p>Terms of Service | Privacy Policy</p>
                        </div>
                    </div>

                </div>
            </div>
        </footer>

        <%@include file="modal.html" %>
        <%@include file="test/ModalTest.html" %>
        <%@include file="test/TableTest.html" %>
    </body>
</html>
