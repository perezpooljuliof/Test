<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/bootstrap.min.css'/>">

        <!--For Plugins external css-->
        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/plugins.css'/>" />
        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/lato-webfont.css'/>" />
        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/magnific-popup.css'/>">

        <!--Theme custom css -->
        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/style.css'/>">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="<spring:url value='/resources/theme/bazinger/assets/css/responsive.css'/>" />
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/vendor/jquery-1.11.2.min.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/vendor/bootstrap.min.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/jquery.magnific-popup.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/plugins.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/main.js'/>"></script>
        <script src="<spring:url value='/resources/theme/bazinger/assets/js/bootstable.js'/>"></script>

        <!-- Seccion for Application -->
        <!-- Page JS and CSS -->
        <script type="text/javascript" src="<spring:url value='/js/base/utilidadesInput.js'/>"></script>
        <script type="text/javascript" src="<spring:url value='/js/producto/inventario.js'/>"></script>
    </head>
    <body>
        <!--Header-->
        <%@include file="../base/header.html" %>

        <!-- Sections -->
        <section id="inventario" class="sections lightbg">
            <div class="container">
                <div class="heading-content">
                    <h3>INVENTARIO</h3>
                </div>
                   <spring:url value='/js/base/utilidadesInput.js'/>
                <ul class="nav nav-tabs">
                  <li class="active"><a data-toggle="tab" href="#home">Productos</a></li>
                </ul>
                <div class="tab-content">
                    <div id="home" class="tab-pane fade in active">
                        <h3>Productos</h3>

                        <form id="formularioPrincipal" method="POST" action="/admin/altaProducto">
                            <div class="row">
                                <div class="col-3 col-md-2">ID:</div>
                                <div class="col-9 col-md-2">
                                    <input type="text" name="id" id="id" size="5" tabindex="1" />
                                    <a href="#" id="play"><i class="fa fa-play fa-lg"></i></a>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-3 col-md-2">Nombre:</div>
                                <div class="col-9 col-md-2"><input type="text" name="nombre" id="nombre" disabled="disabled" tabindex="2"/></div>
                            </div>

                            <div class="row">
                                <div class="col-3 col-md-2">Costo:</div>
                                <div class="col-9 col-md-2"><input type="text" name="costo" id="costo" disabled="disabled" tabindex="3"/></div>

                                <div class="col-3 col-md-2">Precio:</div>
                                <div class="col-9 col-md-2"><input type="text" name="precio" id="precio" disabled="disabled" tabindex="4"/></div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 col-xs-12"><hr/></div>
                            </div>

                            <div class="row">
                                <div class="col-3 col-md-2">Codigo barras:</div>
                                <div class="col-9 col-md-2"><input type="text" name="codigoBarras" id="codigoBarras" disabled="disabled" tabindex="5"/></div>

                                <div class="col-3 col-md-2">Codigo rapido:</div>
                                <div class="col-9 col-md-2"><input type="text" name="codigoRapido" id="codigoRapido" disabled="disabled" tabindex="5"/></div>
                            </div>

                            <br/>
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <button type="button" class="btn btn-primary" disabled="disable" id="agregar" tabindex="8">Agregar</button>
                                    <button type="button" class="btn btn-default" disabled="disable" id="modificar" tabindex="9">Modificar</button>
                                    <button type="button" class="btn btn-default" disabled="disable" id="eliminar" tabindex="10">Eliminar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <!--Footer-->
        <%@include file="../base/footer.html" %>

        <!-- -->
        <%@include file="../base/modal.html" %>
    </body>
</html>
