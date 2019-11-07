$(document).ready(function() {
    $( "#id" ).keydown(function( event ) {
        if ( event.which == 13 ) {
            addOrSearch();
            //event.preventDefault();
        }
    });

    $("#play").click(function() {
        addOrSearch();
    });

    function addOrSearch() {
        var id = $("#id").val();
        console.log("id:" + id);
        if(id == null || id == 0) {
            addProduct();
        }
        else {
            searchProduct();
        }
    }

    function addProduct() {
        enableAddComponents(true);
    }

    function searchProduct() {
        enableSearchComponents(true);
    }

    function enableAddComponents(enabled) {
        enableChildElements('formularioPrincipal', enabled);
        $("#modificar").prop("disabled", true);
        $("#eliminar").prop("disabled", true);
    }

    function enableSearchComponents(enabled) {
        enableChildElements('formularioPrincipal', enabled);
        $("#agregar").prop("disabled", true);
    }

    $("#agregar").click(function( event ) {
        consumeAltaProducto();
    });

    function consumeAltaProducto() {
        console.log("consumeAltaProducto(8)>>>>>>>>>>>>>>>>>>>");
        // Send the data using post
        var productoBean = {
        "idProducto":"1",
        "producto":"Sabriton",
        "costo":"0.0",
        "precio":"0.0",
        "codigoRapido":"344",
        "codigoBarras":"3445566",
        "tipoVentaProd":"",
        "esGravable":"",
        "esIEPS":"",
        "esISH":"",
        "estatus":"",
        "idDepartamento":"",
        "cantidadMinima":"12",
        "cantidadMaxima":"22"
       };

        console.log(JSON.stringify(productoBean));
        request = $.ajax({
            type: "post",
            url: "/Test/Web/Producto/altaProducto",
            data: JSON.stringify(productoBean),
            contentType: "application/json",
            dataType: "json",
            //async: false,

            /*
            beforeSend: function(request) {
            },
            */
            success: function (data) {
                console.log("Exito...");
                console.log(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log("Error.");
                console.log(xhr.status);
                console.log(xhr);
                console.log(thrownError);
                console.log(ajaxOptions);
            }
        });
        //request.abort();
    }

    $.consumeAltaProducto = function() {
        consumeAltaProducto();
    }
});//Termina callbak $( document ).ready