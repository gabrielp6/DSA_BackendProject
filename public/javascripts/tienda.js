var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function() {

    $('#buttonEscudoOro').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/escudoOro"),
                success: function(respuesta) {
                        alert("Escudo de oro comprado correctamente");
                }
            });
        });

    $('#buttonEscudoPlata').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/escudoPlata"),
                success: function(respuesta) {
                        alert("Escudo de plata comprado correctamente");
                }
            });
        });

    $('#buttonEscudoMadera').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/escudoMadera"),
                success: function(respuesta) {
                        alert("Escudo de madera comprado correctamente");
                }
            });
        });

    $('#buttonFlechaOro').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/flechaOro"),
                success: function(respuesta) {
                        alert("Flecha de oro comprada correctamente");
                }
            });
        });

    $('#buttonFlechaPlata').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/flechaPlata"),
                success: function(respuesta) {
                        alert("Flecha de plata comprada correctamente");
                }
            });
    });

    $('#buttonFlechaOro').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/flechaMadera"),
                success: function(respuesta) {
                        alert("Flecha de madera comprada correctamente");
                }
            });
        });

    $('#buttonManzana').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/manzana"),
                success: function(respuesta) {
                        alert("Manzana comprada correctamente");
                }
            });
        });


    $('#buttonPocionAzul').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/comprarObjeto/pocionAzul"),
                success: function(respuesta) {
                        alert("Poción azul comprada correctamente");
                }
            });
        });


    $('#buttonPocionRoja').click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/pocionRoja"),
                success: function(respuesta) {
                        alert("Poción roja comprada correctamente");
                }
            });
        });

})