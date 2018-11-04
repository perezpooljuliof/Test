$(document).ready(function() {
    console.log("inventario>>>>>>>>>>");
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

    $( "#agregar" ).click(function( event ) {
      // Send the data using post
      var posting = $.post( "/Test/admin/altaProducto", { "producto":"Producto Prueba" } );

      // Put the results in a div
      posting.done(function( data ) {
        console.log(data);
      });
    });
});//Termina callbak $( document ).ready