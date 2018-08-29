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
                        <li><a href="#home">Home</a></li>
                        <li class="active"><a href="#inventario">Inventario</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <!-- Sections -->
        <section id="inventario" class="sections lightbg">
            <div class="container text-center">
                <div class="heading-content">
                    <h3>Testimonials</h3>
                </div>

                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
                        Inventario
                    </div>
                </div>
            </div> <!-- /container -->
        </section>

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
    </body>
</html>
